namespace Faxmail.Domain.Entities;

public sealed class FaxMessage
{
    public Guid Id { get; init; }
    public Guid TenantId { get; init; }
    public required string ExternalReference { get; init; }
    public required string FromNumber { get; init; }
    public required string ToNumber { get; init; }
    public required string Subject { get; init; }
    public FaxDirection Direction { get; init; }
    public FaxStatus Status { get; set; }
    public int PageCount { get; init; }
    public DateTime ReceivedAtUtc { get; init; }
    public string? AssignedTeam { get; set; }
    public string? Tags { get; set; }
}

