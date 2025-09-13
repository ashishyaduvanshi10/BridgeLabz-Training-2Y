class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog("Buddy", 3);
        Animal a2 = new Cat("Whiskers", 2);
        Animal a3 = new Bird("Tweety", 1);

        a1.makeSound();  
        a2.makeSound();  
        a3.makeSound();  
    }
}
