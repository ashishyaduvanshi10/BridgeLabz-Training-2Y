package programming_elements.Level1;
import java.util.Scanner;
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / 6.451;

        System.out.println("The area of triangle is " + areaCm + " square cm and " + areaInches + " square inches");
    }
}
