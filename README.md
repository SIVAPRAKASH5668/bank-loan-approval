# Bank Loan Application

The purpose of this project is to build a full-stack bank loan application system with a React frontend and Spring Boot backend. Registered users can create a customer account and apply for a loan. The system evaluates their application according to custom bank loan criteria and responds with approval status and loan limit.

You can interact with the application through the React UI or directly via the API endpoints.

For documentation click [here](#api-documentation)

## Technologies Used

### Backend
This project implements Spring Boot framework with the following dependencies:

- **Lombok** → Java annotation library which helps to reduce boilerplate code
- **Spring Web** → Builds RESTful applications using Spring MVC
- **Spring Security** → Highly customizable authentication and access-control framework for Spring applications
- **Spring Data JPA** → Persists data in SQL stores with Java Persistence API using Spring Data and Hibernate
- **PostgreSQL Driver** → JDBC & R2DBC driver allowing Java programs to connect to PostgreSQL database
- **Swagger** → OAS REST Documentation
- **JUnit, Mockito** → Unit Testing
- **SLF4J** → Logging

### Frontend
- **React** → Component-based UI for loan application submission, status tracking, and admin dashboard
- **Axios** → HTTP client for REST API communication between React and Spring Boot
- **React Router** → Client-side routing for multi-page navigation

## Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- PostgreSQL

### Backend Setup

```bash
# Clone the repository
git clone https://github.com/SIVAPRAKASH5668/bank-loan-approval.git

# Navigate to backend
cd bank-loan-approval

# Configure your PostgreSQL credentials in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bankloan
spring.datasource.username=your_username
spring.datasource.password=your_password

# Run the Spring Boot application
./mvnw spring-boot:run
```

### Frontend Setup

```bash
# Navigate to frontend
cd frontend

# Install dependencies
npm install

# Start the React development server
npm start
```

The React app will run on `http://localhost:3000` and the Spring Boot backend on `http://localhost:8080`.

## API Documentation

Access Swagger UI locally after starting the backend:

> `http://localhost:8080/swagger-ui/index.html`

## API Demonstration

**Step 1. Register Securely**

| Type | Endpoint |
|------|----------|
| POST | `http://localhost:8080/api/v1/users/signup` |

```json
{
    "username": "John Cloud",
    "email": "john@gmail.com",
    "password": "12345"
}
```

Response Token:

> eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2huIENsb3VkIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9DTElFTlQifV0sImlhdCI6MTY2MDU2MTM1NywiZXhwIjoxNjYwNjQ3NzU3fQ.bkxHd1i1jttct0HVnN8pdCICp38wEKPcKGEoVVrfwso

**Step 2. Add New Customer**

| Type | Endpoint |
|------|----------|
| POST | `http://localhost:8080/api/v1/customer/add` |

```json
{
    "nationalIdentityNumber": "93111111111",
    "firstName": "{{$randomFullName}}",
    "lastName": "{{$randomLastName}}",
    "phone": "{{$randomPhoneNumber}}",
    "email": "{{$randomEmail}}",
    "monthlyIncome": "10000",
    "gender": "male",
    "age": "{{$randomInt}}",
    "loanScore": "1000"
}
```

**Step 3. Check New Customer Information**

| Type | Endpoint |
|------|----------|
| GET | `http://localhost:8080/api/v1/customer/get/{nationalIdentityNumber}` |

```json
{
    "nationalIdentityNumber": "93111111111",
    "firstName": "Isaac Terry",
    "lastName": "Baumbach",
    "phone": "9478931929",
    "email": "Leon76@hotmail.com",
    "monthlyIncome": 10000.0,
    "gender": "male",
    "age": 61,
    "loanScore": 1000,
    "loanApplications": []
}
```

**Step 4. Create New Loan Application**

| Type | Endpoint |
|------|----------|
| POST | `http://localhost:8080/api/v1/loanapplication/create/{nationalIdentityNumber}` |

**Step 5. Learn Loan Application Result**

| Type | Endpoint |
|------|----------|
| GET | `http://localhost:8080/api/v1/loanapplication/result/{nationalIdentityNumber}` |

```json
{
    "id": 21,
    "loanType": "PERSONAL",
    "loanLimit": 10000.0,
    "loanScoreResult": "APPROVED",
    "loanStatus": "ACTIVE",
    "loanDate": "15-08-2025",
    "creditMultiplier": 4,
    "loanApplication": {
        "id": 5
    }
}
```

## Loan Evaluation Cases

#### Case 1:
Loan score >= 1000 and monthly income > 5000 → **Approved**, loan limit specially calculated.

```json
{
    "loanLimit": 40000.0,
    "loanScoreResult": "APPROVED",
    "loanStatus": "ACTIVE"
}
```

#### Case 2:
Loan score between 500-1000 and monthly income > 5000 → **Approved**, loan limit 20,000.

```json
{
    "loanLimit": 20000.0,
    "loanScoreResult": "APPROVED",
    "loanStatus": "ACTIVE"
}
```

#### Case 3:
Loan score between 500-1000 and monthly income <= 5000 → **Approved**, loan limit 10,000.

```json
{
    "loanLimit": 10000.0,
    "loanScoreResult": "APPROVED",
    "loanStatus": "ACTIVE"
}
```

#### Case 4:
Loan score < 500 → **Rejected**.

```json
{
    "loanLimit": 0.0,
    "loanScoreResult": "REJECTED",
    "loanStatus": "INACTIVE"
}
```

## Functional Requirements & Analysis

| **USER STORY ID** | **AS A** | **I WANT TO** | **SO THAT** |
|-------------------|----------|---------------|-------------|
| 1 | customer | register to bank loan system | I can create a customer account |
| 2 | customer | add/update/delete loan application | I can manage my loan application |
| 3 | customer | browse my loan application(s) | I can see my list of confirmed and rejected loan applications |
| 4 | customer | login / logout | I can securely enter and leave the system |
| 5 | admin | register to bank loan system | I can perform as a root user such as employee or bank manager |
| 6 | admin | view a loan application request | I can review the application information |
| 7 | admin | confirm / reject | I can respond to the application |
| 8 | admin | add / update / delete a customer of the bank | I can manage customer records |
| 9 | admin | send notification to customer | I can notify customer about the outcome of their loan application |
| 10 | admin | login & logout | I can securely enter and leave the system |

## ERD Database Design

![](https://github.com/gulbalasalamov/bank-loan-application/blob/master/doc/loan-application-erd.png)
