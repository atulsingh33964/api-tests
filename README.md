# FakeStore API Automation (Rest Assured + Java)

This project automates CRUD operations on FakeStore API using Rest Assured, Maven, and JUnit.

## Tech Stack
- Java 17
- Maven
- Rest Assured
- JUnit 5
- Allure Reporting

## API Covered
- GET /products
- GET /products/{id}
- POST /products
- PUT /products/{id}
- DELETE /products/{id}

## How to Run Tests

1. Navigate to project folder:
```
cd api-tests
```

2. Run tests:
```
mvn clean test
```

3. Generate Allure Report:
```
mvn allure:serve
```

## Reports
Allure reports will open in browser showing execution summary.

## Author
Atul Vikram Singh