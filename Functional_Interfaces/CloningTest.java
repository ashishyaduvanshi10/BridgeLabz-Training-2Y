class Product implements Cloneable {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    public String toString() {
        return "Product[name=" + name + ", price=" + price + "]";
    }
}

public class CloningTest {
    public static void main(String[] args) throws Exception {
        Product original = new Product("Laptop", 1200);
        Product copy = original.clone();

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}
