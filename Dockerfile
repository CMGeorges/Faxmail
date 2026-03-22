FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src

COPY ["Faxmail.sln", "./"]
COPY ["Directory.Build.props", "./"]
COPY ["src/Faxmail.Api/Faxmail.Api.csproj", "src/Faxmail.Api/"]
COPY ["src/Faxmail.Application/Faxmail.Application.csproj", "src/Faxmail.Application/"]
COPY ["src/Faxmail.Domain/Faxmail.Domain.csproj", "src/Faxmail.Domain/"]
COPY ["src/Faxmail.Infrastructure/Faxmail.Infrastructure.csproj", "src/Faxmail.Infrastructure/"]

RUN dotnet restore "Faxmail.sln"

COPY . .
RUN dotnet publish "src/Faxmail.Api/Faxmail.Api.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS final
WORKDIR /app

ENV ASPNETCORE_URLS=http://+:10000
EXPOSE 10000

COPY --from=build /app/publish .
ENTRYPOINT ["dotnet", "Faxmail.Api.dll"]

