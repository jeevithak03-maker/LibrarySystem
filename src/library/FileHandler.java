package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String BOOKS_FILE = "books.dat";
    private static final String MEMBERS_FILE = "members.dat";

    public void saveBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(BOOKS_FILE))) {
            oos.writeObject(books);
        } catch (Exception e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public List<Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(BOOKS_FILE))) {
            return (List<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveMembers(List<Member> members) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(MEMBERS_FILE))) {
            oos.writeObject(members);
        } catch (Exception e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }

    public List<Member> loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(MEMBERS_FILE))) {
            return (List<Member>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}