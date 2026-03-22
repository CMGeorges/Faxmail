namespace Faxmail.Application.Contracts;

public sealed record TenantDashboard(
    Guid TenantId,
    string TenantName,
    int TotalFaxes,
    int AssignedFaxes,
    int CompletedFaxes,
    int OverdueFaxes);
