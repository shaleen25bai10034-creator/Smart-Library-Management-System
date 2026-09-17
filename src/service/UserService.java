package service;

import model.Librarian;
import model.Student;

public class UserService {
    private final LibraryService library;

    public UserService(LibraryService library) {
        this.library = library;
    }

    public void addSampleUsers() {
        library.addUser(new Student(1, "Aarav", "aarav@example.com", "B.Tech CSE"));
        library.addUser(new Student(2, "Riya", "riya@example.com", "B.Tech IT"));
        library.addUser(new Librarian(3, "Library Admin", "admin@example.com"));
    }
}
