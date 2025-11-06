import java.util.*;

abstract class JobRole {
    String applicantName;
    JobRole(String applicantName) {
        this.applicantName = applicantName;
    }
    public String toString() {
        return applicantName + " applied for " + this.getClass().getSimpleName();
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String name) {
        super(name);
    }
}

class DataScientist extends JobRole {
    DataScientist(String name) {
        super(name);
    }
}

class ProductManager extends JobRole {
    ProductManager(String name) {
        super(name);
    }
}

class Resume<T extends JobRole> {
    T role;
    Resume(T role) {
        this.role = role;
    }
    public T getRole() {
        return role;
    }
}

class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole job : resumes) {
            System.out.println("Processing: " + job);
        }
    }
}

public class Main16 {
    public static void main(String[] args) {
        List<Resume<SoftwareEngineer>> seResumes = new ArrayList<>();
        seResumes.add(new Resume<>(new SoftwareEngineer("Alice")));
        seResumes.add(new Resume<>(new SoftwareEngineer("Bob")));

        List<Resume<DataScientist>> dsResumes = new ArrayList<>();
        dsResumes.add(new Resume<>(new DataScientist("Charlie")));
        dsResumes.add(new Resume<>(new DataScientist("David")));

        List<Resume<ProductManager>> pmResumes = new ArrayList<>();
        pmResumes.add(new Resume<>(new ProductManager("Emma")));
        pmResumes.add(new Resume<>(new ProductManager("Frank")));

        List<JobRole> allResumes = new ArrayList<>();
        for (Resume<SoftwareEngineer> r : seResumes) allResumes.add(r.getRole());
        for (Resume<DataScientist> r : dsResumes) allResumes.add(r.getRole());
        for (Resume<ProductManager> r : pmResumes) allResumes.add(r.getRole());

        ResumeScreeningSystem.processResumes(allResumes);
    }
}
