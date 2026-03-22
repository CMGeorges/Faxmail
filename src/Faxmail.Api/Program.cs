using Faxmail.Application.Abstractions;
using Faxmail.Application.Contracts;
using Faxmail.Application.Services;
using Faxmail.Infrastructure.Persistence;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSingleton<ITenantRepository, InMemoryTenantRepository>();
builder.Services.AddSingleton<IFaxRepository, InMemoryFaxRepository>();
builder.Services.AddSingleton<FaxOperationsService>();

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "Faxmail API",
    capability = "Multi-tenant fax operations platform"
}));

app.MapGet("/api/tenants", async (FaxOperationsService service, CancellationToken cancellationToken) =>
{
    var tenants = await service.GetTenantsAsync(cancellationToken);
    return Results.Ok(tenants);
});

app.MapGet("/api/tenants/{tenantId:guid}/faxes", async (Guid tenantId, FaxOperationsService service, CancellationToken cancellationToken) =>
{
    var faxes = await service.GetTenantFaxesAsync(tenantId, cancellationToken);
    return Results.Ok(faxes);
});

app.MapPost("/api/tenants/{tenantId:guid}/faxes/intake", async (Guid tenantId, CreateFaxRequest request, FaxOperationsService service, CancellationToken cancellationToken) =>
{
    var fax = await service.IntakeFaxAsync(tenantId, request, cancellationToken);
    return Results.Created($"/api/tenants/{tenantId}/faxes/{fax.Id}", fax);
});

app.MapGet("/api/tenants/{tenantId:guid}/dashboard", async (Guid tenantId, FaxOperationsService service, CancellationToken cancellationToken) =>
{
    var dashboard = await service.GetDashboardAsync(tenantId, cancellationToken);
    return dashboard is null ? Results.NotFound() : Results.Ok(dashboard);
});

app.Run();
