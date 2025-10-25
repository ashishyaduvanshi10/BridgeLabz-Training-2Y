import library.books.*;
import library.members.*;
import library.transactions.*;

public class MainApp {
    public static void main(String[] args) {
        Book b = new Book("Java Basics", "James Gosling");
        Member m = new Member("Amit");
        Transaction t = new Transaction();
        b.show();
        m.show();
        t.issue(b, m);
    }
}
