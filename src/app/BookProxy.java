package app;

public class BookProxy extends Book {
    private RealBook realBook;

    public BookProxy(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public String toString() {
        // Lazy initialization for RealBook
        if (realBook == null) {
            realBook = new RealBook(title, author, category);
        }
        return realBook.toString();
    }
}

