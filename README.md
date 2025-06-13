# Todo Application with JWT Authentication

A secure RESTful Todo application built with Spring Boot, Spring Security, and JWT authentication. This application allows users to manage their personal todos while providing admin capabilities for user management.

## Features

- **User Authentication** with JWT (JSON Web Tokens)
- **Role-based Authorization** (USER, ADMIN)
- **REST API** for all operations
- **User Management**
  - Users can register and login
  - Admins can view all users and delete users
- **Todo Management**
  - Users can create, view, update, and delete their own todos
  - Todos are private to each user

## Technologies Used

- **Backend**: Spring Boot, Spring Security
- **Authentication**: JWT (JSON Web Tokens)
- **Database**: MongoDB
- **Build Tool**: Maven
- **Other**: Lombok

## API Endpoints

### Authentication

| Method | Endpoint           | Description                | Access      |
|--------|--------------------|----------------------------|-------------|
| POST   | `/api/auth/signup` | Register a new user        | Public      |
| POST   | `/api/auth/signin` | Login and get JWT token    | Public      |

### User Management (Admin Only)

| Method | Endpoint          | Description                |
|--------|-------------------|----------------------------|
| GET    | `/api/user`      | Get all users              |
| DELETE | `/api/users/{id}` | Delete a user by ID        |

### Todo Management

| Method | Endpoint               | Description                          | Access      |
|--------|------------------------|--------------------------------------|-------------|
| GET    | `/api/todo`           | Get all todos for current user       | USER        |
| POST   | `/api/todo`           | Create a new todo                    | USER        |
| PUT    | `/api/todo/{id}`      | Update a todo                        | USER |
| DELETE | `/api/todo/{id}`      | Delete a todo                        | USER |

