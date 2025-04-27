# Book My Show - Backend Design

## Introduction

This repository contains the backend code for a movie booking application called Book My Show (BMS). The project focuses on demonstrating effective concurrency handling in a ticket booking system where multiple users may attempt to book the same seats simultaneously.

## Key Features

- User management (registration and profiles)
- City and theatre management
- Auditorium and seat inventory management
- Show scheduling and management
- **Concurrent ticket booking with transaction isolation**
- Seat locking mechanism to prevent overbooking

## Concurrency Management

The core focus of this project is handling concurrent booking requests efficiently. The application implements:

- **Transaction Isolation**: Using Spring's `@Transactional` annotation with `Isolation.SERIALIZABLE` level to ensure the highest level of isolation when booking tickets
- **Pessimistic Locking**: Preventing race conditions when multiple users attempt to book the same seats
- **State Management**: Tracking seat states (AVAILABLE, LOCKED, BOOKED) to manage the booking lifecycle
- **Exception Handling**: Custom exceptions for seat unavailability scenarios

### How Concurrency is Handled

When multiple users attempt to book the same seats:

1. The `TicketService` fetches the requested seats within a serializable transaction
2. It verifies all seats are in AVAILABLE state before proceeding
3. If another concurrent transaction has modified any seat's state, the transaction will fail
4. On successful verification, seats are marked as LOCKED
5. The booking proceeds to create a ticket in PENDING state
6. This approach prevents the double-booking problem common in ticket reservation systems

## Technical Stack

- Java 21
- Spring Boot 3.3.4
- Spring Data JPA
- PostgreSQL Database
- Lombok for boilerplate reduction
- Spring Actuator for application monitoring

## Design Patterns

This project implements several design patterns to maintain code quality, scalability, and separation of concerns:

- **MVC Pattern**: Separation of the application into Models, Controllers, and Services
- **Repository Pattern**: Abstraction of data access through repository interfaces
- **Dependency Injection**: Using Spring's IoC container for managing component dependencies
- **State Pattern**: Implementing seat booking states (AVAILABLE, LOCKED, BOOKED) to manage state transitions
- **Transaction Script**: Encapsulating business logic within transactional methods
- **Builder Pattern**: Utilized for complex object construction (particularly for DTOs)
- **Singleton Pattern**: Spring beans are managed as singletons by default
- **Factory Method**: For creating domain objects with proper initialization

## Class Diagram (with dependencies)

This section is for class diagram with dependencies

![Alternative Text](./assets/class_diagram_with_dependencies.png?raw=true)

## Future Enhancements

- Implement timeout mechanism for locked seats
- Add distributed locking for multi-instance deployments
- Implement seat suggestion algorithm for partially filled shows
- Add payment processing integration
- Implement event-driven architecture for booking notifications
