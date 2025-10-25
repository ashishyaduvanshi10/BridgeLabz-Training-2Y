import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " | Price: $" + price + " | Rating: " + rating + " | Discount: " + discount + "%";
    }
}

public class ECommerceLambdaSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200, 4.6, 15),
            new Product("Headphones", 150, 4.3, 30),
            new Product("Smartphone", 800, 4.8, 10),
            new Product("Camera", 950, 4.5, 25)
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sorting criteria (price/rating/discount): ");
        String criteria = sc.nextLine();

        Comparator<Product> comparator;

        if (criteria.equalsIgnoreCase("price")) {
            comparator = (p1, p2) -> Double.compare(p1.price, p2.price);
        } else if (criteria.equalsIgnoreCase("rating")) {
            comparator = (p1, p2) -> Double.compare(p2.rating, p1.rating);
        } else if (criteria.equalsIgnoreCase("discount")) {
            comparator = (p1, p2) -> Double.compare(p2.discount, p1.discount);
        } else {
            System.out.println("Invalid criteria.");
            return;
        }

        products.sort(comparator);

        System.out.println("\nSorted Products (" + criteria + "):");
        products.forEach(System.out::println);
    }
}
