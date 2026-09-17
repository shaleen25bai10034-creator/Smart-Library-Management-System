import exception.BookNotFoundException;
import exception.BookUnavailableException;
import model.Book;
import service.BookService;
import service.LibraryService;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService library = new LibraryService();

    public static void main(String[] args) {
        new BookService(library).addSampleBooks();
        new UserService(library).addSampleUsers();

        while (true) {
            printMenu();
            int choice = readInt("Enter choice: ");

            try {
                switch (choice) {
                    case 1 -> listBooks();
                    case 2 -> searchBooks();
                    case 3 -> issueBook();
                    case 4 -> returnBook();
                    case 5 -> listUsers();
                    case 6 -> listTransactions();
                    case 7 -> addBook();
                    case 8 -> {
                        System.out.println("Thank you for using Smart Library Management System.");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please select 1-8.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n========== SMART LIBRARY MANAGEMENT SYSTEM ==========");
        System.out.println("1. View all books");
        System.out.println("2. Search books");
        System.out.println("3. Issue a book");
        System.out.println("4. Return a book");
        System.out.println("5. View users");
        System.out.println("6. View transactions");
        System.out.println("7. Add a book");
        System.out.println("8. Exit");
        System.out.println("=====================================================");
    }

    private static void listBooks() {
        System.out.printf("%-5s %-25s %-20s %-15s %-10s%n",
                "ID", "Title", "Author", "Category", "Status");
        for (Book b : library.getBooks()) System.out.println(b);
    }

    private static void searchBooks() {
        String keyword = readLine("Enter title/author/category: ");
        List<Book> result = library.search(keyword);
        if (result.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            for (Book b : result) System.out.println(b);
        }
    }

    private static void issueBook() throws BookNotFoundException, BookUnavailableException {
        int bookId = readInt("Enter book ID: ");
        int userId = readInt("Enter user ID: ");
        library.issueBook(bookId, userId);
        System.out.println("Book issued successfully.");
    }

    private static void returnBook() throws BookNotFoundException {
        int bookId = readInt("Enter book ID: ");
        long fine = library.returnBook(bookId);
        System.out.println("Book returned successfully. Fine: Rs." + fine);
    }

    private static void listUsers() {
        System.out.println("\nID | Name | Email | Role | Course");
        library.getUsers().forEach(System.out::println);
    }

    private static void listTransactions() {
        if (library.getTransactions().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            library.getTransactions().forEach(System.out::println);
        }
    }

    private static void addBook() {
        int id = readInt("Book ID: ");
        String title = readLine("Title: ");
        String author = readLine("Author: ");
        String category = readLine("Category: ");
        library.addBook(new Book(id, title, author, category));
        System.out.println("Book added successfully.");
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
