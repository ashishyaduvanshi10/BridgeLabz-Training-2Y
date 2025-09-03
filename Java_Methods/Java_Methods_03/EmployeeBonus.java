public class EmployeeBonus {
    public static void main(String[] args) {
        int[][] data = new int[10][3];
        double totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            int salary = (int)(Math.random() * 90000) + 10000;
            int years = (int)(Math.random() * 11);
            int bonus = (years > 5) ? (int)(salary * 0.05) : 0;

            data[i][0] = salary;
            data[i][1] = years;
            data[i][2] = bonus;

            totalBonus += bonus;
        }

        System.out.println("Emp\tSalary\tYears\tBonus");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t" + data[i][1] + "\t" + data[i][2]);
        }

        System.out.println("Total Bonus = " + totalBonus);
    }
}
