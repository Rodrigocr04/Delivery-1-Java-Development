import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Register Patron");
            System.out.println("4. Display Patrons");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Edit Book");
            System.out.println("9. Edit Patron");
            System.out.println("10. Display Books borrowed by Patron");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    library.addBook(title, author, isbn, copies);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    library.registerPatron(name, id, contact);
                    break;
                case 4:
                    library.displayPatrons();
                    break;
                case 5:
                    System.out.print("Enter Patron ID: ");
                    String patronId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    library.borrowBook(patronId, bookTitle);
                    break;
                case 6:
                    System.out.print("Enter Patron ID: ");
                    patronId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    bookTitle = scanner.nextLine();
                    library.returnBook(patronId, bookTitle);
                    break;
                case 7:
                    System.out.print("Enter book title, author, or ISBN to remove: ");
                    String removeQuery = scanner.nextLine();
                    library.removeBook(removeQuery);
                    break;
                case 8:
                    System.out.print("Enter book title, author, or ISBN to edit: ");
                    String editQuery = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new ISBN: ");
                    String newIsbn = scanner.nextLine();
                    System.out.print("Enter new number of copies: ");
                    int newCopies = scanner.nextInt();
                    scanner.nextLine();
                    library.editBook(editQuery, newTitle, newAuthor, newIsbn, newCopies);
                    break;
                case 9:
                    System.out.print("Enter Patron ID to edit: ");
                    String patronIdToEdit = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new contact: ");
                    String newContact = scanner.nextLine();
                    library.editPatron(patronIdToEdit, newName, newContact);
                    break;
                case 10:
                    System.out.print("Enter Patron ID to display borrowed books: ");
                    String patronIdToDisplay = scanner.nextLine();
                    library.booksByPatron(patronIdToDisplay);
                    break;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}