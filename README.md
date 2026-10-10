# Employee Management System

A Java web application for managing employee records. It uses Jakarta Servlets to handle requests, Thymeleaf to render the pages, and Hibernate with MySQL for persistence.

## Features

- View the employee list.
- Open a form to add an employee.
- Open an employee record for editing.
- Delete an employee.
- Store employee name, email, department, and salary.

## Technology stack

- Java
- Maven
- Jakarta Servlet API
- Hibernate ORM
- MySQL
- Thymeleaf

## Prerequisites

- JDK compatible with the dependencies in `pom.xml`.
- Maven.
- MySQL Server.
- A Jakarta Servlet 6.1-compatible servlet container, such as Apache Tomcat 11.

## Database setup

Create the database before starting the application:

```sql
CREATE DATABASE employee;
```

Configure the MySQL connection properties in `src/main/resources/hibernate.cfg.xml` for your local database URL, username, and password. Hibernate is configured to update the mapped schema on startup.

## Build and run

Build the deployable WAR from the project root:

```bash
mvn clean package
```

The generated file is `target/EmployeeManagementSystem.war`. Deploy it to a Jakarta Servlet 6.1-compatible container with MySQL available and the connection settings configured. After deployment, open:

```text
http://localhost:8080/EmployeeManagementSystem/employees
```

The context path may differ depending on how the WAR is deployed.

## Application routes

| Method | Path | Purpose |
| --- | --- | --- |
| GET | `/employees` | Display the employee list |
| GET | `/add-employee` | Display the employee form |
| GET | `/edit-employee?id=<employee-id>` | Display the form for an employee |
| POST | `/save-employee` | Submit employee form data |
| GET | `/delete-employee?id=<employee-id>` | Delete an employee and return to the list |

Routes are relative to the deployed application context path.
