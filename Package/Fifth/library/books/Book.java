package library.books;
public class Book {
    String title; String author;
    public Book(String title, String author) {
        this.title = title; this.author = author;
    }
    public void show() {
        System.out.println("Book: " + title + " by " + author);
    }
}
