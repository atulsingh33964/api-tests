# FakeStore API Automation Test Suite

A comprehensive API testing framework for the FakeStore API, built with **Rest Assured** and **Java**. This project demonstrates best practices for REST API automation, including CRUD operations, response validation, and detailed test reporting.

## Project Overview

This automation suite provides end-to-end testing for the FakeStore API's product endpoints. It features:
- Complete CRUD operations testing
- JSON Schema validation
- Comprehensive test reporting with Allure
- Modular architecture with base test classes
- Maven-based build management

## Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Programming language |
| **Maven** | 3.x | Build and dependency management |
| **Rest Assured** | Latest | REST API testing library |
| **JUnit** | 5 | Test framework |
| **Allure** | Latest | Test reporting and visualization |

## 🔌 API Endpoints Tested

The following FakeStore API endpoints are covered:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products` | Retrieve all products |
| GET | `/products/{id}` | Get specific product by ID |
| POST | `/products` | Create new product |
| PUT | `/products/{id}` | Update existing product |
| DELETE | `/products/{id}` | Delete product |

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher installed
- **Maven 3.6+** installed
- **Git** for version control

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd api-tests
```

2. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn test -Dtest=FakeStoreApiTest
```

### Run with Specific Tags/Groups
```bash
mvn test -Dgroups="smoke"
```

## Reports and Visualization

### Generate Allure Report
```bash
mvn allure:serve
```

This command will:
- Generate a detailed HTML report
- Open the report automatically in your default browser
- Display execution summary, test status, and timings

### View Test Logs
```bash
cat api-test-log.txt
```

## 📁 Project Structure

```
api-tests/
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseApiTest.java       # Base test configuration
│       │   └── tests/
│       │       └── FakeStoreApiTest.java  # Test cases
│       └── resources/
│           └── schemas/
│               └── product-schema.json    # JSON schema validation
├── target/                                # Compiled test artifacts
├── allure-results/                        # Test execution reports
├── pom.xml                                # Maven configuration
└── README.md                              # This file
```

## Architecture

### Base Test Class
The `BaseApiTest` class provides:
- Common API configuration
- Shared test utilities and helpers
- Base URL and endpoint management
- Request/response logging

### Test Implementation
The `FakeStoreApiTest` class contains:
- API endpoint testing logic
- Assertion validations
- Schema validation
- Error handling scenarios

## Example Test Execution

```
mvn clean test
[INFO] BUILD SUCCESS
[INFO] Tests run: 5, Failures: 0, Skipped: 0, Errors: 0
[INFO] Allure report generated successfully
```