# Faxmail

Faxmail is a SaaS-ready fax operations platform foundation built with ASP.NET Core and clean architecture principles.

## What is in the repository

- A layered .NET solution ready for API and business logic growth.
- Multi-tenant domain models for enterprise customers.
- An initial high-value SaaS feature: inbound fax routing with SLA-aware triage.
- UML documentation for the whole project in the `docs/uml` folder.

## Solution layout

- `src/Faxmail.Domain`
- `src/Faxmail.Application`
- `src/Faxmail.Infrastructure`
- `src/Faxmail.Api`
- `docs`

## Next focus areas

- Persist data with Entity Framework Core.
- Add authentication and tenant administration.
- Integrate external fax providers and webhooks.
