import java.util.*;

class ListCopy {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number num : src) {
            dest.add(num);
        }
    }
}

public class Main7 {
    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        List<Integer> srcInt = Arrays.asList(1, 2, 3);
        List<Double> srcDouble = Arrays.asList(4.5, 5.5);

        ListCopy.copyList(dest, srcInt);
        ListCopy.copyList(dest, srcDouble);

        System.out.println(dest);
    }
}
