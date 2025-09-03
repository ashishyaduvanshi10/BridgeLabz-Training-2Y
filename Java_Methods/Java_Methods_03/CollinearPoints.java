import java.util.Scanner;

public class CollinearPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        System.out.print("Enter x2 y2: ");
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        System.out.print("Enter x3 y3: ");
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        boolean slopeMethod = (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);

        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        boolean areaMethod = area == 0.0;

        System.out.println("Using slope method: " + (slopeMethod ? "Collinear" : "Not Collinear"));
        System.out.println("Using area method: " + (areaMethod ? "Collinear" : "Not Collinear"));
    }
}
