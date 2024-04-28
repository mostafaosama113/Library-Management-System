# Library Management System README

## Introduction
This project is a library management system built using Spring Boot and Java. It provides endpoints for managing books, patrons, and borrowing activities. The project is organized into packages and follows the standard Maven directory structure.

## Getting Started
To get started with this project, you can refer to the provided API endpoints:
- **Authentication Endpoints**:
    - POST /api/v1/auth/register: Register a new user in the system.
    - POST /api/v1/auth/login: Login for an existent user.
- **Book Management Endpoints**:
    - GET /api/books: Retrieve a list of all books.
    - GET /api/books/{id}: Retrieve details of a specific book by ID.
    - POST /api/books: Add a new book to the library.
    - PUT /api/books/{id}: Update an existing book's information.
    - DELETE /api/books/{id}: Remove a book from the library.

- **Patron Management Endpoints**:
    - GET /api/patrons: Retrieve a list of all patrons.
    - GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
    - POST /api/patrons: Add a new patron to the system.
    - PUT /api/patrons/{id}: Update an existing patron's information.
    - DELETE /api/patrons/{id}: Remove a patron from the system.

- **Borrowing Endpoints**:
    - POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
    - PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.

## Project Structure
The project's directory and file organization is primarily centered around a Maven-based Java application. The main directories are `src`, `test`, and `pom.xml`, which is the core configuration file for Maven.

### Key Directories and Files

1. `pom.xml`: This is the Project Object Model (POM) file, which contains the project's configuration details, dependencies, and build instructions.
2. `src`: This directory contains the source code and resources for the project.
    - `main`: This directory contains the main source code and resources for the application.
        - `java`: This directory contains the Java source code organized under packages.
            - `com`: This directory contains the Java source code organized under a package named "com".
        - `resources`: This directory contains non-Java resources like configuration files and static files.
            - `application.properties`: This is a configuration file for the application.
            - `static`: This directory contains static files like HTML, CSS, JavaScript, etc.
    - `test`: This directory contains the test source code and resources for the application.
        - `java`: This directory contains the Java source code for the test cases, also organized under packages.
            - `com`: This directory contains the Java source code for the test cases, also organized under a package named "com".

## Notable Aspects
The project's organization follows the standard Maven directory structure, which is widely used for Java projects. The use of packages (`com`) for organizing Java source code is a common practice in Java projects. The separation of main source code and resources from the test source code and resources is a good practice for maintaining project organization.
