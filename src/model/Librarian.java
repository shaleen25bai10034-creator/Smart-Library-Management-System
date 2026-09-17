package model;

public class Librarian extends User {
    public Librarian(int userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public String getRole() { return "Librarian"; }

    @Override
    public String toString() {
        return getUserId() + " | " + getName() + " | " + getEmail() + " | Librarian";
    }
}
