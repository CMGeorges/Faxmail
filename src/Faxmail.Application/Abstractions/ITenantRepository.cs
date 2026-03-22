using Faxmail.Domain.Entities;

namespace Faxmail.Application.Abstractions;

public interface ITenantRepository
{
    Task<IReadOnlyList<Tenant>> GetAllAsync(CancellationToken cancellationToken);
    Task<Tenant?> GetByIdAsync(Guid tenantId, CancellationToken cancellationToken);
}

