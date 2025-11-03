public class BankLimit {
    public static double remainingLimit(Double limitUsed, double totalLimit) {
        if (limitUsed == null) return totalLimit; 
        return totalLimit - limitUsed;
    }

    public static void main(String[] args) {
        System.out.println("Remaining (null): " + remainingLimit(null, 5000));
        System.out.println("Remaining (used 1500): " + remainingLimit(1500.0, 5000));
    }
}
