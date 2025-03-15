import java.util.*;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;
    private Map<String, List<Book>> borrowedBooks;

    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    public void addBook(String title, String author, String isbn, int copies) {
        books.add(new Book(title, author, isbn, copies));
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            book.displayBook();
        }
    }

    public void removeBook(String query) {
        Book bookToRemove = searchBook(query);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void editBook(String query, String newTitle, String newAuthor, String newIsbn, int newCopies) {
        Book bookToEdit = searchBook(query);
        if (bookToEdit != null) {
            bookToEdit.setTitle(newTitle);
            bookToEdit.setAuthor(newAuthor);
            bookToEdit.setIsbn(newIsbn);
            bookToEdit.setCopies(newCopies);
            System.out.println("Book edited successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void registerPatron(String name, String id, String contact) {
        patrons.add(new Patron(name, id, contact));
        System.out.println("Patron registered successfully.");
    }

    public void displayPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons registered.");
            return;
        }
        for (Patron patron : patrons) {
            patron.displayPatron();
        }
    }

    public void editPatron(String patronId, String newName, String newContact) {
        for (Patron patron : patrons) {
            if (patron.getId().equals(patronId)) {
                patron.setName(newName);
                patron.setContact(newContact);
                System.out.println("Patron edited successfully.");
                return;
            }
        }
        System.out.println("Patron not found.");
    }

    public void booksByPatron(String patronId) {
        List<Book> borrowed = borrowedBooks.getOrDefault(patronId, new ArrayList<>());
        if (borrowed.isEmpty()) {
            System.out.println("No books borrowed by this patron.");
        } else {
            System.out.println("Books borrowed by patron " + patronId + ":");
            for (Book book : borrowed) {
                book.displayBook();
            }
        }
    }

    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query) || book.getIsbn().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String patronId, String bookTitle) {
        Patron patron = patrons.stream().filter(p -> p.getId().equals(patronId)).findFirst().orElse(null);
        Book book = searchBook(bookTitle);
        if (patron == null || book == null || book.getCopies() <= 0) {
            System.out.println("Borrowing failed. Patron or book not found, or no copies available.");
            return;
        }
        book.setCopies(book.getCopies() - 1);
        borrowedBooks.computeIfAbsent(patronId, k -> new ArrayList<>()).add(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(String patronId, String bookTitle) {
        List<Book> borrowed = borrowedBooks.getOrDefault(patronId, new ArrayList<>());
        Book book = borrowed.stream().filter(b -> b.getTitle().equalsIgnoreCase(bookTitle)).findFirst().orElse(null);
        if (book == null) {
            System.out.println("Return failed. Book not found.");
            return;
        }
        book.setCopies(book.getCopies() + 1);
        borrowed.remove(book);
        System.out.println("Book returned successfully.");
    }
}