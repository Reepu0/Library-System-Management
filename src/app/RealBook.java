package app;

public class RealBook extends Book {
    
    public RealBook(String title, String author, String category) {
        super(title, author, category);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + category + ")";
    }
}
