
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankTransactionManager {

    
    public static void verifyAccount(String accountNumber) throws AccountNotFoundException {
        
        if (!accountNumber.equals("ACC123")) {
            throw new AccountNotFoundException(" Account not found! Please check your account number.");
        }
        System.out.println("Account verified successfully: " + accountNumber);
    }


    public static void processTransaction(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance! Transaction amount exceeds account balance.");
        }
        System.out.println(" Transaction of ₹" + amount + " processed successfully.");
    }

    
    public static void executeTransaction(String accountNumber, double balance, double amount) throws Exception {
        verifyAccount(accountNumber);       
        processTransaction(balance, amount); 
        System.out.println(" Transaction completed successfully!");
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("===  Bank Transaction Manager ===");

        try {
            
            executeTransaction("ACC123", 10000, 2000);

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
    }
}

