using Faxmail.Application.Abstractions;
using Faxmail.Domain.Entities;

namespace Faxmail.Infrastructure.Persistence;

public sealed class InMemoryTenantRepository : ITenantRepository
{
    private static readonly IReadOnlyList<Tenant> Tenants =
    [
        new Tenant
        {
            Id = Guid.Parse("11111111-1111-1111-1111-111111111111"),
            Name = "Northwind Health",
            Slug = "northwind-health",
            Plan = "enterprise"
        },
        new Tenant
        {
            Id = Guid.Parse("22222222-2222-2222-2222-222222222222"),
            Name = "Crestline Legal",
            Slug = "crestline-legal",
            Plan = "growth"
        }
    ];

    public Task<IReadOnlyList<Tenant>> GetAllAsync(CancellationToken cancellationToken) =>
        Task.FromResult(Tenants);

    public Task<Tenant?> GetByIdAsync(Guid tenantId, CancellationToken cancellationToken) =>
        Task.FromResult(Tenants.SingleOrDefault(t => t.Id == tenantId));
}

