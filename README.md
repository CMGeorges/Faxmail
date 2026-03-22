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

## Deploy on Render

This project is ready for Render's free web service tier using Docker.

### Public test URL behavior

- Render free services can spin down after inactivity.
- The first request after idle time can be slower.
- Use `/health` to confirm the service is running.

### Deploy steps

1. Push this repository to GitHub.
2. In Render, create a new Blueprint or Web Service from the repository.
3. Render will detect the `render.yaml` file and build the Docker image.
4. Once deployed, test:
   - `/`
   - `/health`
   - `/api/tenants`
   - `/api/tenants/11111111-1111-1111-1111-111111111111/dashboard`

### Why this works on Render

- `Dockerfile` publishes the ASP.NET Core API.
- The container listens on port `10000`, which matches Render's common web service setup.
- `render.yaml` defines a free web service with a health check.

## Next focus areas

- Persist data with Entity Framework Core.
- Add authentication and tenant administration.
- Integrate external fax providers and webhooks.
