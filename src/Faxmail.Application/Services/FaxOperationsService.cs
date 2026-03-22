using Faxmail.Application.Abstractions;
using Faxmail.Application.Contracts;
using Faxmail.Domain.Entities;

namespace Faxmail.Application.Services;

public sealed class FaxOperationsService
{
    private readonly IFaxRepository _faxRepository;
    private readonly ITenantRepository _tenantRepository;

    public FaxOperationsService(IFaxRepository faxRepository, ITenantRepository tenantRepository)
    {
        _faxRepository = faxRepository;
        _tenantRepository = tenantRepository;
    }

    public Task<IReadOnlyList<Tenant>> GetTenantsAsync(CancellationToken cancellationToken) =>
        _tenantRepository.GetAllAsync(cancellationToken);

    public Task<IReadOnlyList<FaxMessage>> GetTenantFaxesAsync(Guid tenantId, CancellationToken cancellationToken) =>
        _faxRepository.GetByTenantAsync(tenantId, cancellationToken);

    public async Task<FaxMessage> IntakeFaxAsync(Guid tenantId, CreateFaxRequest request, CancellationToken cancellationToken)
    {
        var route = BuildRoute(request);

        var faxMessage = new FaxMessage
        {
            Id = Guid.NewGuid(),
            TenantId = tenantId,
            ExternalReference = $"FAX-{DateTime.UtcNow:yyyyMMddHHmmss}-{Guid.NewGuid():N}"[..28],
            FromNumber = request.FromNumber,
            ToNumber = request.ToNumber,
            Subject = request.Subject,
            Direction = FaxDirection.Inbound,
            Status = FaxStatus.Assigned,
            Priority = route.Priority,
            BusinessArea = route.BusinessArea,
            PageCount = request.PageCount,
            ReceivedAtUtc = DateTime.UtcNow,
            DueByUtc = route.DueByUtc,
            AssignedTeam = route.AssignedTeam,
            Tags = BuildTags(request, route)
        };

        return await _faxRepository.AddAsync(faxMessage, cancellationToken);
    }

    public async Task<TenantDashboard?> GetDashboardAsync(Guid tenantId, CancellationToken cancellationToken)
    {
        var tenant = await _tenantRepository.GetByIdAsync(tenantId, cancellationToken);
        if (tenant is null)
        {
            return null;
        }

        var faxes = await _faxRepository.GetByTenantAsync(tenantId, cancellationToken);
        return new TenantDashboard(
            tenant.Id,
            tenant.Name,
            faxes.Count,
            faxes.Count(f => f.Status == FaxStatus.Assigned),
            faxes.Count(f => f.Status == FaxStatus.Completed),
            faxes.Count(IsOverdue));
    }

    public async Task<TenantAnalytics?> GetAnalyticsAsync(Guid tenantId, CancellationToken cancellationToken)
    {
        var tenant = await _tenantRepository.GetByIdAsync(tenantId, cancellationToken);
        if (tenant is null)
        {
            return null;
        }

        var faxes = await _faxRepository.GetByTenantAsync(tenantId, cancellationToken);
        var byTeam = faxes
            .Where(f => !string.IsNullOrWhiteSpace(f.AssignedTeam))
            .GroupBy(f => f.AssignedTeam!)
            .ToDictionary(group => group.Key, group => group.Count(), StringComparer.OrdinalIgnoreCase);

        return new TenantAnalytics(
            tenantId,
            faxes.Count,
            faxes.Count(f => f.Priority is FaxPriority.High or FaxPriority.Critical),
            faxes.Count(IsOverdue),
            byTeam);
    }

    private static bool IsOverdue(FaxMessage fax) =>
        fax.Status is not FaxStatus.Completed && fax.DueByUtc is not null && fax.DueByUtc < DateTime.UtcNow;

    private static (BusinessArea BusinessArea, FaxPriority Priority, string AssignedTeam, DateTime DueByUtc) BuildRoute(CreateFaxRequest request)
    {
        var subject = request.Subject.ToLowerInvariant();
        var businessArea =
            subject.Contains("court") || subject.Contains("legal") ? BusinessArea.Legal :
            subject.Contains("patient") || subject.Contains("referral") || subject.Contains("clinical") ? BusinessArea.Clinical :
            subject.Contains("invoice") || subject.Contains("billing") ? BusinessArea.Billing :
            BusinessArea.Operations;

        var priority =
            request.IsVipSender || subject.Contains("urgent") ? FaxPriority.Critical :
            request.PageCount >= 10 ? FaxPriority.High :
            FaxPriority.Normal;

        var assignedTeam = businessArea switch
        {
            BusinessArea.Clinical => "Clinical Intake",
            BusinessArea.Legal => "Legal Operations",
            BusinessArea.Billing => "Billing Review",
            _ => "Shared Operations"
        };

        var dueByUtc = priority switch
        {
            FaxPriority.Critical => DateTime.UtcNow.AddMinutes(15),
            FaxPriority.High => DateTime.UtcNow.AddMinutes(30),
            _ => DateTime.UtcNow.AddHours(2)
        };

        return (businessArea, priority, assignedTeam, dueByUtc);
    }

    private static string BuildTags(CreateFaxRequest request, (BusinessArea BusinessArea, FaxPriority Priority, string AssignedTeam, DateTime DueByUtc) route)
    {
        var tags = new List<string> { "new", route.BusinessArea.ToString().ToLowerInvariant(), route.Priority.ToString().ToLowerInvariant() };

        if (!string.IsNullOrWhiteSpace(request.ReceivedChannel))
        {
            tags.Add(request.ReceivedChannel.Trim().ToLowerInvariant());
        }

        if (request.IsVipSender)
        {
            tags.Add("vip");
        }

        return string.Join(",", tags);
    }
}
