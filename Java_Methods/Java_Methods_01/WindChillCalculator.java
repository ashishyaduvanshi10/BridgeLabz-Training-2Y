import java.util.Scanner;

public class WindChillCalculator {
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature 
               + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();
        WindChillCalculator w = new WindChillCalculator();
        double windChill = w.calculateWindChill(temperature, windSpeed);
        System.out.println("The wind chill temperature is " + windChill);
        sc.close();
    }
}
