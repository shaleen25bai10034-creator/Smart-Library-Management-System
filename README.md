# Smart Library Management System

## Overview
Smart Library Management System is a console-based Java application that demonstrates object-oriented programming concepts through common library operations.

## Features
- Book management
- User management
- Book search
- Issue and return operations
- Automatic overdue fine calculation
- Transaction history
- Input validation and exception handling

## Technologies
- Java
- OOP
- Java Collections Framework
- Java Time API
- JUnit 5 for tests
- Git/GitHub

## Requirements
- JDK 17 or later
- Optional: Maven/IDE for JUnit tests

## Run
Compile from the `src` directory:

```bash
javac -d ../out Main.java model/*.java service/*.java exception/*.java util/*.java
java -cp ../out Main
```

If your IDE is used, open the project and run `src/Main.java`.

## Testing
The project contains `test/LibraryServiceTest.java`. Add JUnit 5 to the project classpath or run the tests through an IDE/Maven setup.

## Main Modules
1. User Management
2. Book Management
3. Issue/Return Management
4. Search and Reporting
5. Validation and Exception Handling

## Academic Purpose
This project is developed as a VITyarthi Build Your Own Project for a Java course and demonstrates modular object-oriented software development.
