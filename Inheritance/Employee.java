class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String mentorName;

    public Intern(String name, int id, double salary, String mentorName) {
        super(name, id, salary);
        this.mentorName = mentorName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Mentor: " + mentorName);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Manager("Alice", 101, 90000, 10);
        Employee e2 = new Developer("Bob", 102, 70000, "Java");
        Employee e3 = new Intern("Charlie", 103, 30000, "David");

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}
