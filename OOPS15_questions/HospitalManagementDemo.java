interface Payable {
    double calculatePayment();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = "";
    }

    public Patient(String patientId, String name, int age, String medicalHistory) {
        this(patientId, name, age);
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getSummary() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract void displayInfo();
}

class InPatient extends Patient {
    private String roomNumber;

    public InPatient(String patientId, String name, int age, String medicalHistory, String roomNumber) {
        super(patientId, name, age, medicalHistory);
        this.roomNumber = roomNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("InPatient: " + getSummary() + ", Room: " + roomNumber);
    }
}

class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String patientId, String name, int age, String appointmentDate) {
        super(patientId, name, age);
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("OutPatient: " + getSummary() + ", Appointment: " + appointmentDate);
    }
}

class Doctor {
    private String doctorId;
    private String name;
    private String specialization;

    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor: " + name + " (" + specialization + ")");
    }
}

class Bill implements Payable {
    private double baseAmount;
    private double discount;
    private double tax;

    public Bill(double baseAmount, double discount, double tax) {
        this.baseAmount = baseAmount;
        this.discount = discount;
        this.tax = tax;
    }

    @Override
    public double calculatePayment() {
        double discounted = baseAmount - (baseAmount * discount / 100);
        return discounted + (discounted * tax / 100);
    }

    public void printBill() {
        System.out.println("Total Payable: $" + calculatePayment());
    }
}

public class HospitalManagementDemo {
    public static void main(String[] args) {
        Doctor doc = new Doctor("D101", "Dr. Smith", "Cardiology");
        doc.displayInfo();

        InPatient p1 = new InPatient("P001", "Alice", 45, "Heart Surgery", "Room 202");
        OutPatient p2 = new OutPatient("P002", "Bob", 30, "2025-09-23");

        p1.displayInfo();
        p2.displayInfo();

        Bill bill = new Bill(5000, 10, 5);
        bill.printBill();
    }
}
