import java.io.*;

class Employee implements Serializable {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Employee[name=" + name + ", id=" + id + "]";
    }
}

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee("Alice", 101);

        FileOutputStream fos = new FileOutputStream("employee.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp);
        oos.close();
        fos.close();

        System.out.println("Employee serialized successfully.");
    }
}
