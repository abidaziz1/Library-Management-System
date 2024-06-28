import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add books to the library
        System.out.println("Enter number of books to add:");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter book title:");
            String title = scanner.nextLine();
            System.out.println("Enter book author:");
            String author = scanner.nextLine();
            System.out.println("Enter book ISBN:");
            String isbn = scanner.nextLine();
            Book book = new Book(title, author, isbn);
            library.addBook(book);
        }

        // Register members
        System.out.println("Enter number of members to register:");
        int numMembers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numMembers; i++) {
            System.out.println("Enter member name:");
            String name = scanner.nextLine();
            System.out.println("Enter member ID:");
            String memberId = scanner.nextLine();
            Member member = new Member(name, memberId);
            library.addMember(member);
        
        }

        while (true) {
            System.out.println("Choose an operation: 1) Borrow book 2) Return book 3) Check availability 4) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Borrow a book
                System.out.println("Enter ISBN of the book to borrow:");
                String isbn = scanner.nextLine();
                System.out.println("Enter member ID:");
                String memberId = scanner.nextLine();
                try {
                    library.borrowBook(isbn, memberId);
                    System.out.println("Book borrowed successfully");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 2) {
                // Return a book
                System.out.println("Enter ISBN of the book to return:");
                String isbn = scanner.nextLine();
                System.out.println("Enter member ID:");
                String memberId = scanner.nextLine();
                try {
                    library.returnBook(isbn, memberId);
                    System.out.println("Book returned successfully");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 3) {
                // Check book availability
                System.out.println("Enter ISBN of the book to check availability:");
                String isbn = scanner.nextLine();
                library.checkBookAvailability(isbn);
            } else if (choice == 4) {
                // Exit
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

