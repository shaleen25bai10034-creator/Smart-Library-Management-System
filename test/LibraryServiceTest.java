import exception.BookUnavailableException;
import model.Book;
import model.Student;
import org.junit.jupiter.api.Test;
import service.LibraryService;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {
    @Test
    void issueBookMakesBookUnavailable() throws Exception {
        LibraryService library = new LibraryService();
        library.addBook(new Book(1, "Java", "Author", "Programming"));
        library.addUser(new Student(1, "Test User", "test@example.com", "CSE"));

        library.issueBook(1, 1);

        assertFalse(library.findBook(1).isAvailable());
        assertEquals(1, library.getTransactions().size());
    }

    @Test
    void cannotIssueSameBookTwice() throws Exception {
        LibraryService library = new LibraryService();
        library.addBook(new Book(1, "Java", "Author", "Programming"));
        library.addUser(new Student(1, "A", "a@example.com", "CSE"));
        library.addUser(new Student(2, "B", "b@example.com", "IT"));

        library.issueBook(1, 1);

        assertThrows(BookUnavailableException.class, () -> library.issueBook(1, 2));
    }

    @Test
    void returnBookMakesBookAvailable() throws Exception {
        LibraryService library = new LibraryService();
        library.addBook(new Book(1, "Java", "Author", "Programming"));
        library.addUser(new Student(1, "A", "a@example.com", "CSE"));

        library.issueBook(1, 1);
        library.returnBook(1);

        assertTrue(library.findBook(1).isAvailable());
    }
}
