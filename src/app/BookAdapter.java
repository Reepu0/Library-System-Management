/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author OS
 */
public class BookAdapter extends Book {
    private ExternalBook externalBook;

    public BookAdapter(ExternalBook externalBook) {
        super(externalBook.getBookTitle(), externalBook.getBookAuthor(), externalBook.getBookCategory());
        this.externalBook = externalBook;
    }

    @Override
    public String toString() {
        return externalBook.getBookTitle() + " by " + externalBook.getBookAuthor() + " (" + externalBook.getBookCategory() + ")";
    }
}

