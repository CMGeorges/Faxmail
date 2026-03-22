# Faxmail

Faxmail is a SaaS-ready fax operations platform foundation built with ASP.NET Core and clean architecture principles.

## Recruiter Overview

Faxmail is a portfolio-ready backend project that demonstrates how to design a multi-tenant SaaS platform for regulated document intake.

It is built to show:

- clean architecture with clear separation of concerns
- ASP.NET Core minimal API design
- domain-driven modeling for tenants and fax workflows
- SaaS-oriented features such as smart routing, SLA handling, and tenant analytics
- architecture communication through versioned UML documentation

## Demo Value

This project is intentionally structured like an enterprise-ready system rather than a simple CRUD exercise.

Key business capabilities:

- multi-tenant fax intake
- automated routing by business area
- SLA-based prioritization
- operational dashboard per tenant
- analytics endpoint for monitoring workload and overdue items

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

## Tech Stack

- .NET 8
- ASP.NET Core Minimal APIs
- Clean Architecture
- In-memory repositories for demo simplicity
- PlantUML documentation
- Docker for deployment
- Render for free public hosting

## Quick Test Guide

Once deployed on Render, these endpoints give a fast overview of the project:

- `GET /`
- `GET /health`
- `GET /api/tenants`
- `GET /api/tenants/11111111-1111-1111-1111-111111111111/faxes`
- `GET /api/tenants/11111111-1111-1111-1111-111111111111/dashboard`
- `GET /api/tenants/11111111-1111-1111-1111-111111111111/analytics`

Example intake request:

```bash
curl -X POST "https://your-render-url.onrender.com/api/tenants/11111111-1111-1111-1111-111111111111/faxes/intake" \
  -H "Content-Type: application/json" \
  -d '{
    "fromNumber": "+1-555-111-2222",
    "toNumber": "+1-555-333-4444",
    "subject": "Urgent patient referral",
    "pageCount": 12,
    "receivedChannel": "portal",
    "isVipSender": true
  }'
```

Expected result:

- the fax is auto-classified
- a business team is assigned
- a priority is calculated
- an SLA due date is generated

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

## What To Say In An Interview

You can present Faxmail as:

"A SaaS-oriented ASP.NET Core backend prototype for intelligent fax intake. I designed it with layered architecture, tenant isolation at the domain level, automated routing rules, SLA-aware prioritization, and UML documentation to communicate system design clearly."

## Next focus areas

- Persist data with Entity Framework Core.
- Add authentication and tenant administration.
- Integrate external fax providers and webhooks.
