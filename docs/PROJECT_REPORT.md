# Smart Library Management System — Project Report

## 1. Cover Page
**Project:** Smart Library Management System  
**Course:** Java  
**Student:** Shaleen Dutta  
**Registration Number:** 25BAI10034  
**University:** VIT BHOPAL UNIVERSITY  
**Academic Year:** Fall Semester 2026-27

## 2. Introduction
The Smart Library Management System is a console-based Java application developed to demonstrate object-oriented programming in a practical scenario. It organizes library books, users, issue/return transactions, searching, and fine calculation.

## 3. Problem Statement
Manual tracking of library records may lead to difficulty in identifying book availability, maintaining issue records, and calculating overdue fines. The proposed system provides a structured digital approach.

## 4. Functional Requirements
1. Add and display books.
2. Search books by title, author, or category.
3. Add and display users.
4. Issue available books to valid users.
5. Return issued books.
6. Calculate overdue fines.
7. Display transaction history.
8. Validate input and report errors.

## 5. Non-Functional Requirements
- **Usability:** Menu-driven interface with clear prompts.
- **Reliability:** Exceptions prevent invalid operations from crashing the program.
- **Maintainability:** Separate model, service, exception, and utility packages.
- **Performance:** In-memory collections provide fast access for the academic-scale dataset.
- **Resource efficiency:** The console application uses lightweight Java collections.
- **Error handling:** Invalid IDs, unavailable books, and invalid numeric input are handled.

## 6. System Architecture
Presentation layer (Main menu) communicates with service layer (LibraryService, BookService, UserService), which manages model objects (Book, User, Student, Librarian, Transaction). Custom exceptions provide controlled error reporting.

## 7. Design Diagrams

### Use Case Diagram
```text
Student/Member ---> Search Books
Student/Member ---> Issue Book
Student/Member ---> Return Book
Librarian -------> Add Book
Librarian -------> View Users
Librarian -------> View Transactions
```

### Workflow
```text
Start
  |
Display Menu
  |
Select Operation
  |
Validate Input
  |
Process Request
  |
Display Result/Error
  |
Return to Menu
  |
Exit
```

### Sequence Diagram — Issue Book
```text
User -> Main: Select Issue Book
Main -> LibraryService: issueBook(bookId,userId)
LibraryService -> LibraryService: Validate user
LibraryService -> Book: Check availability
Book --> LibraryService: Available
LibraryService -> Transaction: Create transaction
LibraryService -> Book: Set unavailable
LibraryService --> Main: Success
Main --> User: Display result
```

### Class/Component Diagram
```text
                User (abstract)
                /            \
           Student         Librarian

Book
Transaction

LibraryService
   |-- manages Book
   |-- manages User
   |-- manages Transaction

BookService ------> LibraryService
UserService ------> LibraryService
Main -------------> LibraryService

BookNotFoundException
BookUnavailableException
```

### ER/Storage Design
The current implementation uses in-memory Java collections rather than a relational database.

Logical entities:
```text
USER(User_ID, Name, Email, Role, Course)
BOOK(Book_ID, Title, Author, Category, Available)
TRANSACTION(Transaction_ID, Book_ID, User_ID, Issue_Date, Return_Date)
```

## 8. Design Decisions & Rationale
- **Encapsulation:** model fields are private and accessed through methods.
- **Inheritance:** Student and Librarian extend User.
- **Abstraction:** User is abstract because different user roles share common information.
- **Collections:** ArrayList is appropriate for the small academic dataset.
- **Exceptions:** custom exceptions make operational errors understandable.
- **Separation of concerns:** models and services are placed in separate packages.

## 9. Implementation Details
The program starts with sample books and users. A menu allows the user to select operations. LibraryService performs book search, issue, return, and transaction management. Returning a book calculates a fine using Java's LocalDate and ChronoUnit APIs.

## 10. Screenshots / Results
Take screenshots of:
1. Main menu
2. All books
3. Search result
4. Successful issue
5. Successful return
6. Error when issuing an unavailable book
7. Transaction history

## 11. Testing Approach
JUnit tests verify:
- Successful book issue.
- Prevention of duplicate issue.
- Successful return.
- Availability status changes.

Manual validation also checks invalid menu choices and invalid numeric input.

## 12. Challenges Faced
- Designing relationships between books, users, and transactions.
- Handling invalid operations without terminating the application.
- Separating classes into maintainable modules.
- Implementing fine calculation based on dates.

## 13. Learnings & Key Takeaways
- Practical application of encapsulation, inheritance, abstraction, and polymorphism.
- Use of Java Collections.
- Custom exception handling.
- Modular package organization.
- Basic software testing.
- Importance of validation and clean architecture.

## 14. Future Enhancements
- MySQL/SQLite database integration.
- Login and role-based authentication.
- GUI using JavaFX.
- Persistent transaction history.
- Email notifications for due dates.
- Advanced reports and dashboards.

## 15. References
- Java SE API documentation.
- Course material and classroom notes.
- VITyarthi project submission guidelines.
