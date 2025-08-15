# Blog API Practice Project

This repository contains a simple blog API built with **Spring Boot** and **Spring Security**. The project is designed for learning and practicing how to build secure RESTful APIs using modern Spring technologies.

## Features

- User authentication with JWT (JSON Web Tokens)
- Secure login endpoint
- Example of service and controller layers
- Spring Data JPA integration
- PostgreSQL database configuration
- Clean, modular code structure

## Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (io.jsonwebtoken)
- Lombok

## Getting Started

1. **Clone the repository:**
   ```
   git clone https://github.com/your-username/blog-api-practice.git
   cd blog-api-practice
   ```

2. **Configure the database:**
   - Update `src/main/resources/application.properties` with your PostgreSQL credentials if needed.

3. **Build and run the application:**
   ```
   ./mvnw spring-boot:run
   ```

4. **API Endpoints:**
   - `POST /api/auth/login` — Authenticate and receive a JWT token

## Purpose

This project is intended for educational purposes, to help you understand:

- How to set up Spring Boot projects
- How to implement authentication and authorization with Spring Security and JWT
- How to structure a REST API with service and controller layers

Feel free to fork, modify, and use this project as a starting point for your own experiments with Spring Boot and Spring Security!

## License

This project is for practice and educational use.

---
