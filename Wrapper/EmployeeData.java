import java.util.*;

public class EmployeeData {
    public static void main(String[] args) {
        int[] ages = {25, 30, 45, 22, 50};

        ArrayList<Integer> ageList = new ArrayList<>();
        for (int a : ages) {
            ageList.add(a); 
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Employee ages: " + ageList);
        System.out.println("Youngest age: " + youngest);
        System.out.println("Oldest age: " + oldest);
    }
}
