import com.company.hr.Employee;
import com.company.payroll.*;

public class MainApp {
    public static void main(String[] args) {
        Employee e = new Employee(1, "Ravi", "IT", 50000);
        Payroll p = new Payroll();
        p.calculateBonus(e);
        System.out.println("Employee: " + e.getName() + ", Final Salary: " + e.getSalary());
    }
}
