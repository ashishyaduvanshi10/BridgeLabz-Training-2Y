import java.util.ArrayList;
import java.util.List;

interface ICheckout {
    void generateBill();
    void applyDiscount();
}

abstract class Product {
    protected String name;
    protected double price;
    protected String category;
    protected int quantity;

    public Product(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public abstract double getDiscountedPrice();
    public double getTotalPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }
}

class PerishableProduct extends Product {
    public PerishableProduct(String name, double price, String category, int quantity) {
        super(name, price, category, quantity);
    }

    @Override
    public double getDiscountedPrice() {
        return getTotalPrice() * 0.90; // 10% off
    }
}

class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price, String category, int quantity) {
        super(name, price, category, quantity);
    }

    @Override
    public double getDiscountedPrice() {
        return getTotalPrice() * 0.95; // 5% off
    }
}

class Cart implements ICheckout {
    private List<Product> products;
    private double totalPrice;

    public Cart() {
        products = new ArrayList<>();
        totalPrice = 0;
    }

    public Cart(List<Product> initialProducts) {
        this.products = initialProducts;
        recalculateTotal();
    }

    public void addProduct(Product p) {
        products.add(p);
        recalculateTotal();
    }

    private void recalculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getTotalPrice();
        }
    }

    @Override
    public void applyDiscount() {
        double discountedTotal = 0;
        for (Product p : products) {
            discountedTotal += p.getDiscountedPrice();
        }
        totalPrice = discountedTotal;
    }

    @Override
    public void generateBill() {
        System.out.println("------ SwiftCart Bill ------");
        for (Product p : products) {
            System.out.println(p.getName() + " (" + p.category + ") x" + p.quantity + " = $" + p.getTotalPrice());
        }
        System.out.println("Total after discount: $" + totalPrice);
        System.out.println("---------------------------");
    }
}

public class SwiftCartDemo {
    public static void main(String[] args) {
        Product milk = new PerishableProduct("Milk", 2.5, "Dairy", 4);
        Product bread = new PerishableProduct("Bread", 1.5, "Bakery", 2);
        Product rice = new NonPerishableProduct("Rice", 10, "Grains", 1);
        Product soap = new NonPerishableProduct("Soap", 3, "Toiletries", 3);

        Cart cart = new Cart();
        cart.addProduct(milk);
        cart.addProduct(bread);
        cart.addProduct(rice);
        cart.addProduct(soap);

        cart.applyDiscount();
        cart.generateBill();
    }
}
