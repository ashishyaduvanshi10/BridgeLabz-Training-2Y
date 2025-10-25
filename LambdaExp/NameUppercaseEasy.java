import java.util.*;

public class NameUppercaseEasy {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ashish", "Nikhil", "Apransh", "Yash");

        System.out.println("Names in Uppercase:");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
