package model;

import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int bookId;
    private int userId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(int transactionId, int bookId, int userId) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = LocalDate.now();
    }

    public int getTransactionId() { return transactionId; }
    public int getBookId() { return bookId; }
    public int getUserId() { return userId; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public long getFine() {
        LocalDate end = isReturned() ? returnDate : LocalDate.now();
        long days = java.time.temporal.ChronoUnit.DAYS.between(issueDate, end);
        return Math.max(0, days - 14) * 5;
    }

    @Override
    public String toString() {
        return "Transaction " + transactionId + " | Book: " + bookId +
                " | User: " + userId + " | Issued: " + issueDate +
                " | Returned: " + (returnDate == null ? "Not returned" : returnDate) +
                " | Fine: Rs." + getFine();
    }
}
