# README.md

# Expense Tracker Application

This is an Expense Tracker application built using Spring Boot. The application allows users to manage their expenses by categorizing them and tracking transactions.

## Features

- User authentication and registration
- CRUD operations for categories
- CRUD operations for transactions
- JWT-based authentication

## Project Structure

```
backend
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── expensetracker
│   │   │               ├── controller
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── CategoryController.java
│   │   │               │   └── TransactionController.java
│   │   │               ├── model
│   │   │               │   ├── Category.java
│   │   │               │   └── Transaction.java
│   │   │               ├── repository
│   │   │               │   ├── CategoryRepository.java
│   │   │               │   └── TransactionRepository.java
│   │   │               └── security
│   │   │                   └── JwtTokenProvider.java
│   │   └── resources
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd backend
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```

### Running the Application

To run the application, use the following command:
```
mvn spring-boot:run
```

### API Endpoints

- **Authentication**
  - `POST /api/auth/register`: Register a new user
  - `POST /api/auth/login`: Authenticate a user and receive a JWT token

- **Categories**
  - `POST /api/categories`: Create a new category
  - `GET /api/categories`: Retrieve all categories
  - `GET /api/categories/{id}`: Retrieve a category by ID
  - `PUT /api/categories/{id}`: Update a category
  - `DELETE /api/categories/{id}`: Delete a category

- **Transactions**
  - `POST /api/transactions`: Create a new transaction
  - `GET /api/transactions`: Retrieve all transactions
  - `GET /api/transactions/{id}`: Retrieve a transaction by ID
  - `PUT /api/transactions/{id}`: Update a transaction
  - `DELETE /api/transactions/{id}`: Delete a transaction

## License

This project is licensed under the MIT License.