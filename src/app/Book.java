package app;

public class Book {
    String title;
    String author;
    String category;
    private boolean isBorrowed;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;  // Default status is not borrowed
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + category + ")" + (isBorrowed ? " [Borrowed]" : " [Available]");
    }
}
