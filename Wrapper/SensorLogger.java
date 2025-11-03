public class SensorLogger {

    public static void logTemperature(Double temp) {
        System.out.println("Logged temperature: " + temp);
    }

    public static void main(String[] args) {
        double t1 = 36.5;     
        Double t2 = 37.2;     
        logTemperature(t1);   
        logTemperature(t2);   
    }
}

