using Faxmail.Domain.Entities;

namespace Faxmail.Application.Abstractions;

public interface IFaxRepository
{
    Task<IReadOnlyList<FaxMessage>> GetByTenantAsync(Guid tenantId, CancellationToken cancellationToken);
    Task<FaxMessage> AddAsync(FaxMessage faxMessage, CancellationToken cancellationToken);
}

