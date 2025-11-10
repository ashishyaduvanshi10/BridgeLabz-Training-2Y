import java.util.*;
public class ClassWork1 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(13,45,56,24,23));
        System.out.println(list);
        Collections.sort(list);
        System.out.println("Sorted List " + list);
        Collections.reverse(list);
        System.out.println("Reversed list " + list);
        System.out.println("Max of list " + Collections.max(list));
        System.out.println("Min of list " + Collections.min(list));
    
    }
    
}
