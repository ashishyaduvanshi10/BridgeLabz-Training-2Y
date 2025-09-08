import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getCost() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(String name, double price, int qty) {
        items.add(new CartItem(name, price, qty));
        System.out.println(name + " added to cart.");
    }

    void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equalsIgnoreCase(name)) {
                items.remove(i);
                System.out.println(name + " removed from cart.");
                return;
            }
        }
        System.out.println(name + " not found in cart.");
    }

    void displayTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getCost();
        }
        System.out.println("Total Cost: " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Laptop", 50000, 1);
        cart.addItem("Mouse", 800, 2);
        cart.displayTotal();

        cart.removeItem("Mouse");
        cart.displayTotal();
    }
}
