# Vancouver Explorer 🌲

**An AI-powered Vancouver discovery assistant - built with Java, Spring Boot, GraphQL, and React (planned).**

## About the Project

I recently moved to Vancouver, Canada, and wanted to build something that would help me discover and experience my new city.

Vancouver Explorer started as a personal project to explore local attractions, neighbourhoods, activities, and hidden gems while strengthening my full-stack development skills and learning how to build agentic AI applications.

The long-term goal is to create an intelligent assistant that can understand natural-language requests, consider preferences such as budget and interests, and use tools to recommend personalized experiences around Vancouver.

Rather than simply generating suggestions, the assistant will eventually be able to retrieve relevant information, evaluate options, and build practical exploration plans.

## Current Features

The backend currently supports:

- A GraphQL API for retrieving Vancouver places.
- Place information including name, category, neighbourhood, description, estimated cost, and indoor/outdoor classification.
- Optional budget-based filtering.
- A service and repository architecture with dependency injection.
- An in-memory repository containing initial Vancouver locations.
- Unit tests using JUnit 5 and Mockito.
- GraphQL integration tests using Spring Boot's GraphQL testing framework.

## Tech Stack

| Layer | Technologies |
|---|---|
| Backend | Java 21, Spring Boot |
| API | Spring for GraphQL |
| Data | In-memory repository |
| Testing | JUnit 5, Mockito, GraphQlTester |
| Build | Maven |
| Frontend (planned) | React, TypeScript |
| AI (planned) | LLM integration and tool-calling agent |

## Architecture

```text
GraphQL API
    |
    v
PlaceQuery
    |
    v
PlaceService
    |
    v
PlaceRepository
    |
    v
InMemoryPlaceRepository
```

This separation allows the application to evolve from a simple place-discovery API into an AI-powered assistant without tightly coupling its business logic to the API or data layer.

## Example GraphQL Query

```graphql
query {
  places(maxCost: 15) {
    name
    neighbourhood
    estimatedCost
  }
}
```

The query retrieves places with an estimated cost of CAD $15 or less.

## Getting Started

### Prerequisites

- Java 21
- Maven (or use the included Maven wrapper)

### Run the Backend

Clone the repository:

```bash
git clone https://github.com/namratharao7/vancouver-explorer.git
cd vancouver-explorer
```

Start the Spring Boot application:

```bash
./mvnw spring-boot:run
```

Open GraphiQL at:

`http://localhost:8080/graphiql`

### Run Tests

```bash
./mvnw test
```

## Roadmap

- [x] Initialize Spring Boot backend
- [x] Create GraphQL API
- [x] Implement place discovery and budget filtering
- [x] Introduce service and repository layers
- [x] Add unit and integration tests
- [ ] Integrate an LLM into the Java backend
- [ ] Implement AI tool calling for place discovery
- [ ] Support multi-step agentic planning
- [ ] Expand place data and integrate external APIs
- [ ] Build a React and TypeScript frontend
- [ ] Add personalized recommendations and itinerary generation

## The Agentic AI Vision

The goal is to move beyond a traditional chatbot toward an assistant that can decide which tools to use based on a user's request.

For example:

*"I have a free Saturday afternoon, a $30 budget, and I'd like to explore Vancouver without a car."*

The planned agent will be able to interpret the request, search for suitable places, consider practical constraints, and assemble a personalized plan.

The focus is on learning how to build reliable, extensible AI applications where language models work alongside conventional backend services.

## Project Status

**In active development.**

The core Java and GraphQL backend is wired up. AI integration and frontend development are upcoming milestones.