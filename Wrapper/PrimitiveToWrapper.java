import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer value: ");
        int num = sc.nextInt();  


        Integer obj = Integer.valueOf(num);


        int primitiveValue = obj.intValue();

        
        System.out.println("\nConversion Results");
        System.out.println("Primitive value: " + primitiveValue);
        System.out.println("Wrapper object value: " + obj);

        sc.close();
    }
}
