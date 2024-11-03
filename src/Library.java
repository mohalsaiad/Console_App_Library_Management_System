import java.util.ArrayList;

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
    }

    public void viewBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            String status = book.isBorrowed() ? " (Borrowed)" : " (Available)";
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + status);
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("You've borrowed: " + title);
                    return;
                } else {
                    System.out.println("Sorry, the book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("You've returned: " + title);
                    return;
                } else {
                    System.out.println("This book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }
}
