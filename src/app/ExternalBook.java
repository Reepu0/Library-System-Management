/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author OS
 */
public class ExternalBook {
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;

    public ExternalBook(String title, String author, String category) {
        this.bookTitle = title;
        this.bookAuthor = author;
        this.bookCategory = category;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }
}
