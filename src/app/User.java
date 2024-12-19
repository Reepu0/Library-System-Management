package app;

import java.util.List;
import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected String userType;
    protected List<Book> borrowedBooks;  // حفظ قائمة الكتب المستعارة

    public User(String name, String userType) {
        this.name = name;
        this.userType = userType;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }

    // إضافة أو إزالة كتب مستعارة
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // تنفيذ الإجراء الخاص بالمستخدم
    public abstract void performActions();
}
