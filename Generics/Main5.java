import java.util.ArrayList;

class Fruit {
    String name;
    Fruit(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Apple extends Fruit {
    Apple() {
        super("Apple");
    }
}

class Mango extends Fruit {
    Mango() {
        super("Mango");
    }
}

class FruitBox<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();
    public void add(T fruit) {
        fruits.add(fruit);
    }
    public void display() {
        for (T fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

public class Main5 {
    public static void main(String[] args) {
        FruitBox<Fruit> box = new FruitBox<>();
        box.add(new Apple());
        box.add(new Mango());
        box.display();
    }
}

class Car {
    String model = "Car";
}
