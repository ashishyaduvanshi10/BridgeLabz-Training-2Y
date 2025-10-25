import java.util.Random;

interface IInteractable {
    void feed();
    void play();
    void sleep();
}

abstract class Pet implements IInteractable {
    private String name;
    private String type;
    private int age;
    private int hunger;
    private int mood;
    private int energy;

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = new Random().nextInt(50);
        this.mood = new Random().nextInt(50);
        this.energy = new Random().nextInt(50);
    }

    public Pet(String type) {
        this("Unknown", type, new Random().nextInt(10) + 1);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getHunger() {
        return hunger;
    }

    public int getMood() {
        return mood;
    }

    public int getEnergy() {
        return energy;
    }

    protected void changeHunger(int val) {
        hunger = Math.max(0, Math.min(100, hunger + val));
    }

    protected void changeMood(int val) {
        mood = Math.max(0, Math.min(100, mood + val));
    }

    protected void changeEnergy(int val) {
        energy = Math.max(0, Math.min(100, energy + val));
    }

    public abstract void makeSound();

    public void feed() {
        changeHunger(-20);
        changeMood(10);
    }

    public void play() {
        changeMood(20);
        changeEnergy(-15);
        changeHunger(10);
    }

    public void sleep() {
        changeEnergy(30);
        changeHunger(5);
    }
}

class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }
    public Dog() {
        super("Dog");
    }
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }
    public Cat() {
        super("Cat");
    }
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}

class Bird extends Pet {
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }
    public Bird() {
        super("Bird");
    }
    public void makeSound() {
        System.out.println(getName() + " says: Tweet!");
    }
}

public class PetPal {
    public static void main(String[] args) {
        Pet dog = new Dog("Buddy", 3);
        Pet cat = new Cat();
        Pet bird = new Bird("Tweety", 1);

        dog.makeSound();
        dog.feed();
        dog.play();
        dog.sleep();

        cat.makeSound();
        cat.feed();

        bird.makeSound();
        bird.play();

        System.out.println(dog.getName() + " Energy: " + dog.getEnergy());
        System.out.println(cat.getName() + " Hunger: " + cat.getHunger());
        System.out.println(bird.getName() + " Mood: " + bird.getMood());
    }
}
