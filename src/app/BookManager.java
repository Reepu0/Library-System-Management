package app;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static BookManager instance;
    private List<Book> books;

    // Constructor
    private BookManager() {
        books = new ArrayList<>();
    }

    // طريقة Singleton لإرجاع نسخة واحدة من BookManager
    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book not found");
        }
        books.remove(book);
    }

    // إضافة كتاب خارجي باستخدام Adapter
    public void addExternalBook(ExternalBook externalBook) {
        Book adaptedBook = new BookAdapter(externalBook); // تحويل ExternalBook إلى Book باستخدام BookAdapter
        books.add(adaptedBook); // إضافة الكتاب إلى قائمة الكتب
    }
}
