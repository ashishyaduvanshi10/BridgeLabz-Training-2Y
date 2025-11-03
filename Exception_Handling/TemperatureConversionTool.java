import java.util.*;

// 🔹 Custom Exception Class
class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

// 🔹 Main Class
public class TemperatureConversionTool {

    // Method to validate and convert temperature
    public static double convertTemperature(double value, char unit) throws InvalidTemperatureException {
        if (unit == 'C' || unit == 'c') {
            if (value < -273.15) {
                throw new InvalidTemperatureException("Error: Temperature below absolute zero is not possible!");
            }
            // Celsius to Fahrenheit
            return (value * 9 / 5) + 32;
        } else if (unit == 'F' || unit == 'f') {
            if (value < -459.67) {
                throw new InvalidTemperatureException("Error: Temperature below absolute zero is not possible!");
            }
            // Fahrenheit to Celsius
            return (value - 32) * 5 / 9;
        } else {
            throw new InvalidTemperatureException("Error: Invalid unit! Please enter C for Celsius or F for Fahrenheit.");
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Temperature Conversion Tool ===");
        try {
            System.out.print("Enter temperature value: ");
            double temp = sc.nextDouble();

            System.out.print("Enter unit (C/F): ");
            char unit = sc.next().charAt(0);

            double converted = convertTemperature(temp, unit);

            if (unit == 'C' || unit == 'c') {
                System.out.printf(" %.2f°C = %.2f°F%n", temp, converted);
            } else {
                System.out.printf(" %.2f°F = %.2f°C%n", temp, converted);
            }

        } catch (InvalidTemperatureException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number and unit.");
        } finally {
            sc.close();
            System.out.println("=== Program Ended ===");
        }
    }
}
