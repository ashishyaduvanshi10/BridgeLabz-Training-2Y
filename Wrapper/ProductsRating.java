import java.util.*;
import java.util.stream.Collectors;

public class ProductsRating {
    public static void main(String[] args) {
        int[] oldRatings = {4, 5, 3};
        ArrayList<Integer> newRatings = new ArrayList<>(Arrays.asList(5, null, 4));

        ArrayList<Integer> combined = new ArrayList<>();

        
        for (int r : oldRatings) combined.add(r);

        combined.addAll(newRatings);

    
        List<Integer> validRatings = combined.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        double avg = validRatings.stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("All ratings: " + combined);
        System.out.println("Valid ratings: " + validRatings);
        System.out.println("Average rating: " + avg);
    }
}

