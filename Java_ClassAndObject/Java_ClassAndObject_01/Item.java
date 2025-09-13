class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double totalCost(int quantity) {
        return price * quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Item item = new Item(101, "Notebook", 50.0);
        item.displayDetails();
        int quantity = 5;
        System.out.println("Total Cost for " + quantity + " items: " + item.totalCost(quantity));
    }
}
