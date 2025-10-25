import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> isHighTemp = temp -> temp > 37.5;

        double temp1 = 36.8;
        double temp2 = 38.2;

        System.out.println("Temp " + temp1 + " high? " + isHighTemp.test(temp1));
        System.out.println("Temp " + temp2 + " high? " + isHighTemp.test(temp2));
    }
}
