namespace Faxmail.Application.Contracts;

public sealed record CreateFaxRequest(
    string FromNumber,
    string ToNumber,
    string Subject,
    int PageCount,
    string? ReceivedChannel,
    bool IsVipSender);

