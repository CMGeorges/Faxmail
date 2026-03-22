using Faxmail.Domain.Entities;

namespace Faxmail.Application.Abstractions;

public interface IFaxRepository
{
    Task<IReadOnlyList<FaxMessage>> GetByTenantAsync(Guid tenantId, CancellationToken cancellationToken);
    Task<FaxMessage?> GetByIdAsync(Guid tenantId, Guid faxId, CancellationToken cancellationToken);
    Task<FaxMessage> AddAsync(FaxMessage faxMessage, CancellationToken cancellationToken);
    Task<FaxMessage> UpdateAsync(FaxMessage faxMessage, CancellationToken cancellationToken);
}
