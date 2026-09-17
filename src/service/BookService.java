package service;

import model.Book;

public class BookService {
    private final LibraryService library;

    public BookService(LibraryService library) {
        this.library = library;
    }

    public void addSampleBooks() {
        library.addBook(new Book(101, "Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book(102, "Java: The Complete Reference", "Herbert Schildt", "Java"));
        library.addBook(new Book(103, "Data Structures", "Seymour Lipschutz", "Computer Science"));
        library.addBook(new Book(104, "Effective Java", "Joshua Bloch", "Java"));
    }
}
