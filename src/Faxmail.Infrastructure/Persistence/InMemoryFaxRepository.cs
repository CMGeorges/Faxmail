using System.Collections.Concurrent;
using Faxmail.Application.Abstractions;
using Faxmail.Domain.Entities;

namespace Faxmail.Infrastructure.Persistence;

public sealed class InMemoryFaxRepository : IFaxRepository
{
    private readonly ConcurrentDictionary<Guid, List<FaxMessage>> _tenantFaxes = new();

    public InMemoryFaxRepository()
    {
        SeedTenant(Guid.Parse("11111111-1111-1111-1111-111111111111"), "Referral Intake");
        SeedTenant(Guid.Parse("22222222-2222-2222-2222-222222222222"), "Signed Court Filing");
    }

    public Task<IReadOnlyList<FaxMessage>> GetByTenantAsync(Guid tenantId, CancellationToken cancellationToken)
    {
        var items = _tenantFaxes.GetOrAdd(tenantId, _ => []);
        return Task.FromResult<IReadOnlyList<FaxMessage>>(items.OrderByDescending(x => x.ReceivedAtUtc).ToList());
    }

    public Task<FaxMessage> AddAsync(FaxMessage faxMessage, CancellationToken cancellationToken)
    {
        var items = _tenantFaxes.GetOrAdd(faxMessage.TenantId, _ => []);
        lock (items)
        {
            items.Add(faxMessage);
        }

        return Task.FromResult(faxMessage);
    }

    private void SeedTenant(Guid tenantId, string subject)
    {
        _tenantFaxes[tenantId] =
        [
            new FaxMessage
            {
                Id = Guid.NewGuid(),
                TenantId = tenantId,
                ExternalReference = $"SEED-{tenantId.ToString()[..8]}",
                FromNumber = "+1-555-0100",
                ToNumber = "+1-555-0200",
                Subject = subject,
                Direction = FaxDirection.Inbound,
                Status = FaxStatus.Received,
                PageCount = 4,
                ReceivedAtUtc = DateTime.UtcNow.AddMinutes(-20),
                Tags = "seed"
            }
        ];
    }
}

