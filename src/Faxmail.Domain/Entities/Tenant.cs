namespace Faxmail.Domain.Entities;

public sealed class Tenant
{
    public Guid Id { get; init; }
    public required string Name { get; init; }
    public required string Slug { get; init; }
    public required string Plan { get; init; }
    public bool IsActive { get; set; } = true;
}

