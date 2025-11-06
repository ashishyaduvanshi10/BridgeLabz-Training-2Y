import java.util.*;

interface Category {
    String getCategoryName();
}

enum BookCategory implements Category {
    FICTION, EDUCATION, COMICS;

    public String getCategoryName() {
        return name();
    }
}

enum ClothingCategory implements Category {
    MEN, WOMEN, KIDS;

    public String getCategoryName() {
        return name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getCategoryName() {
        return name();
    }
}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return name + " - " + category.getCategoryName() + " - " + price;
    }
}

class Marketplace {
    List<Product<?>> catalog = new ArrayList<>();

    public void addProduct(Product<?> product) {
        catalog.add(product);
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.price - (product.price * percentage / 100);
        product.setPrice(newPrice);
    }

    public void showCatalog() {
        for (Product<?> p : catalog) {
            System.out.println(p);
        }
    }
}

public class Main13 {
    public static void main(String[] args) {
        Marketplace marketplace = new Marketplace();

        Product<BookCategory> book = new Product<>("Harry Potter", 500, BookCategory.FICTION);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 800, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 20000, GadgetCategory.MOBILE);

        marketplace.addProduct(book);
        marketplace.addProduct(shirt);
        marketplace.addProduct(phone);

        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(phone, 5);

        marketplace.showCatalog();
    }
}
