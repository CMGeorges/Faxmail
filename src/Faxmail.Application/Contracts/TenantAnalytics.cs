namespace Faxmail.Application.Contracts;

public sealed record TenantAnalytics(
    Guid TenantId,
    int TotalFaxes,
    int HighPriorityFaxes,
    int OverdueFaxes,
    IReadOnlyDictionary<string, int> VolumeByTeam);

