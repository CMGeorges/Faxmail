using Faxmail.Domain.Entities;

namespace Faxmail.Application.Contracts;

public sealed record RoutedFaxResponse(
    Guid FaxId,
    string ExternalReference,
    BusinessArea BusinessArea,
    FaxPriority Priority,
    string AssignedTeam,
    DateTime? DueByUtc);

