package library;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Library library = new Library();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Register Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> library.displayAllBooks();
                case 3 -> searchBook();
                case 4 -> registerMember();
                case 5 -> borrowBook();
                case 6 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        Book book = new Book(isbn, title, author, year);
        library.addBook(book);
    }

    static void searchBook() {
        System.out.print("Enter keyword: ");
        String key = sc.nextLine();

        List<Book> results = library.searchBooks(key);
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : results) {
                System.out.println(b);
            }
        }
    }

    static void registerMember() {
        System.out.print("Enter Member ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        Member member = new Member(id, name);
        library.registerMember(member);
    }

    static void borrowBook() {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();

        library.borrowBook(isbn, memberId);
    }
}