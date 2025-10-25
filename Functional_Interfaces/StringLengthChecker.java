import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> getLength = str -> str.length();

        String msg1 = "Hello";
        String msg2 = "This is a long message";

        System.out.println("Length of '" + msg1 + "': " + getLength.apply(msg1));
        System.out.println("Length of '" + msg2 + "': " + getLength.apply(msg2));
    }
}
