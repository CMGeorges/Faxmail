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
        var faxMessage = new FaxMessage
        {
            Id = Guid.NewGuid(),
            TenantId = tenantId,
            ExternalReference = $"FAX-{DateTime.UtcNow:yyyyMMddHHmmss}-{Guid.NewGuid():N}"[..28],
            FromNumber = request.FromNumber,
            ToNumber = request.ToNumber,
            Subject = request.Subject,
            Direction = FaxDirection.Inbound,
            Status = FaxStatus.Received,
            PageCount = request.PageCount,
            ReceivedAtUtc = DateTime.UtcNow,
            Tags = "new"
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
            faxes.Count(f => f.Status == FaxStatus.Completed));
    }
}

