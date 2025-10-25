import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}

public class DateFormatTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Default format: " + DateUtils.formatDate(today, "yyyy-MM-dd"));
        System.out.println("Custom format: " + DateUtils.formatDate(today, "dd/MM/yyyy"));
        System.out.println("Full format: " + DateUtils.formatDate(today, "EEEE, MMM dd yyyy"));
    }
}
