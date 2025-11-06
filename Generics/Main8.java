import java.util.*;

class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

class AnimalPrinter {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}

public class Main8 {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog("Dog 1"), new Dog("Dog 2"));
        List<Cat> cats = Arrays.asList(new Cat("Cat 1"), new Cat("Cat 2"));

        AnimalPrinter.printAnimals(dogs);
        AnimalPrinter.printAnimals(cats);
    }
}
