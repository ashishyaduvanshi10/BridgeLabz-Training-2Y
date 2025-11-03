import java.util.Random;


class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


class NetworkFailureException extends Exception {
    public NetworkFailureException(String message) {
        super(message);
    }
}


class Transaction {
    private double balance = 10000; 

    public void processTransaction(double amount) throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {
        Random random = new Random();
        int outcome = random.nextInt(3);  

    
        if (amount < 0) {
            throw new NegativeAmountException("Transaction failed: Amount cannot be negative!");
        }

        
        switch (outcome) {
            case 0:
                if (amount > balance) {
                    throw new InsufficientFundsException("Transaction failed: Insufficient balance!");
                } else {
                    balance -= amount;
                    System.out.println("Transaction successful! Withdrawn: ₹" + amount);
                    System.out.println("Remaining Balance: ₹" + balance);
                }
                break;
            case 1:
                throw new NetworkFailureException(" Transaction failed: Network connection lost!");
            case 2:
                System.out.println("✅ Transaction completed successfully for ₹" + amount);
                break;
        }
    }
}
public class BankingTransactionSystem {
    public static void main(String[] args) {
        Transaction t1 = new Transaction();

        System.out.println("=== Banking Transaction System ===");

        try {
            
            t1.processTransaction(5000);
        } catch (NegativeAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (NetworkFailureException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for using our banking services!");
        }
    }
}
