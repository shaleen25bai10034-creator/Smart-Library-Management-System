package model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("%-5d %-25s %-20s %-15s %-10s",
                bookId, title, author, category, available ? "Available" : "Issued");
    }
}
