# UserService Microservice

A Spring Boot microservice for user management, authentication, and authorization.

## Features

- User registration and login
- Token-based authentication
- Role-based authorization
- User profile management

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Maven
- JSON Web Tokens (JWT)

## Prerequisites

- JDK 17 or later
- Maven 3.6+
- MySQL/PostgreSQL Database

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Tejas1018/UserService.git
   cd UserService
   ```

2. Configure the database connection in `src/main/resources/application.properties`

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication

#### Sign Up
```
POST /api/auth/signup
```
Request body:
```json
{
    "email": "user@example.com",
    "password": "password",
    "name": "User Name"
}
```

#### Login
```
POST /api/auth/login
```
Request body:
```json
{
    "email": "user@example.com",
    "password": "password"
}
```

### User Management

- `GET /api/users` - Get all users (Admin only)
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

## Security

- Authentication is handled using JWT tokens
- Passwords are encrypted using BCrypt
- Role-based access control implemented

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/service/userservice/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── exceptions/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       └── application.properties
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.
