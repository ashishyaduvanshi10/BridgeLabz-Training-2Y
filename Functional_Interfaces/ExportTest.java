interface Exporter {
    void exportToCSV();
    void exportToPDF();

    default void exportToJSON() {
        System.out.println("Exported data to JSON using default method.");
    }
}

class Report implements Exporter {
    public void exportToCSV() {
        System.out.println("Data exported to CSV");
    }
    public void exportToPDF() {
        System.out.println("Data exported to PDF");
    }
}

public class ExportTest {
    public static void main(String[] args) {
        Exporter report = new Report();

        report.exportToCSV();
        report.exportToPDF();
        report.exportToJSON();
    }
}
