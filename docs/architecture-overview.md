# Faxmail Architecture Overview

Faxmail is now organized as a SaaS-ready .NET solution with clear boundaries:

- `Faxmail.Domain`: core business models and rules.
- `Faxmail.Application`: use cases, service contracts, and orchestration.
- `Faxmail.Infrastructure`: repository implementations and cross-cutting concerns.
- `Faxmail.Api`: HTTP surface for tenants, faxes, routing, and analytics.

This structure creates a clean starting point for enterprise growth while staying small enough to evolve quickly.

