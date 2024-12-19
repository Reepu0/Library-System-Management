package app;

public class BookBuilder {
    private String title;
    private String author;
    private String category;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public Book build() {
        return new Book(title, author, category) {};
    }
}
