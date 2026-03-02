package library;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private String borrowedBy;
    private LocalDate dueDate;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }
    public void setBorrowedBy(String borrowedBy) { this.borrowedBy = borrowedBy; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public boolean isOverdue() {
        if (dueDate == null) return false;
        return LocalDate.now().isAfter(dueDate);
    }

    public String toString() {
        return "ISBN: " + isbn + " | Title: " + title +
               " | Author: " + author + " | Year: " + year +
               " | " + (available ? "Available" : "Borrowed");
    }
}