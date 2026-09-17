package service;

import exception.BookNotFoundException;
import exception.BookUnavailableException;
import model.Book;
import model.Transaction;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();
    private int nextTransactionId = 1;

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> getBooks() { return books; }
    public List<User> getUsers() { return users; }
    public List<Transaction> getTransactions() { return transactions; }

    public Book findBook(int id) throws BookNotFoundException {
        for (Book b : books) if (b.getBookId() == id) return b;
        throw new BookNotFoundException("Book with ID " + id + " was not found.");
    }

    public boolean userExists(int id) {
        return users.stream().anyMatch(u -> u.getUserId() == id);
    }

    public void issueBook(int bookId, int userId)
            throws BookNotFoundException, BookUnavailableException {
        if (!userExists(userId)) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
        Book book = findBook(bookId);
        if (!book.isAvailable()) {
            throw new BookUnavailableException("Book is already issued.");
        }
        book.setAvailable(false);
        transactions.add(new Transaction(nextTransactionId++, bookId, userId));
    }

    public long returnBook(int bookId) throws BookNotFoundException {
        Book book = findBook(bookId);
        for (Transaction t : transactions) {
            if (t.getBookId() == bookId && !t.isReturned()) {
                t.returnBook();
                book.setAvailable(true);
                return t.getFine();
            }
        }
        throw new IllegalStateException("No active issue transaction found for this book.");
    }

    public List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();
        String k = keyword.toLowerCase();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(k)
                    || b.getAuthor().toLowerCase().contains(k)
                    || b.getCategory().toLowerCase().contains(k)) {
                result.add(b);
            }
        }
        return result;
    }
}
