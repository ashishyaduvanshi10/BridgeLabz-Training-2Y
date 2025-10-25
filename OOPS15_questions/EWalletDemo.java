import java.util.ArrayList;
import java.util.List;

interface Transferrable {
    void transferTo(User receiver, double amount);
}

class Transaction {
    private String details;
    private double amount;

    public Transaction(String details, double amount) {
        this.details = details;
        this.amount = amount;
    }

    public void printTransaction() {
        System.out.println(details + ": $" + amount);
    }
}

abstract class Wallet implements Transferrable {
    protected double balance;
    protected List<Transaction> history;

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
        this.history = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        history.add(new Transaction("Added Money", amount));
    }

    public void showHistory() {
        for (Transaction t : history) {
            t.printTransaction();
        }
    }
}

class PersonalWallet extends Wallet {
    public PersonalWallet(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.getWallet().balance += amount;
            history.add(new Transaction("Transfer to " + receiver.getName(), amount));
            receiver.getWallet().history.add(new Transaction("Received from " + receiver.getName(), amount));
        } else {
            System.out.println("Insufficient balance for transfer");
        }
    }
}

class BusinessWallet extends Wallet {
    private double limit;

    public BusinessWallet(double initialBalance, double limit) {
        super(initialBalance);
        this.limit = limit;
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (balance >= amount && amount <= limit) {
            balance -= amount;
            receiver.getWallet().balance += amount;
            history.add(new Transaction("Business Transfer to " + receiver.getName(), amount));
            receiver.getWallet().history.add(new Transaction("Received from " + receiver.getName(), amount));
        } else {
            System.out.println("Transfer exceeds limit or insufficient balance");
        }
    }
}

class User {
    private String userId;
    private String name;
    private Wallet wallet;

    public User(String userId, String name, boolean isBusiness) {
        this.userId = userId;
        this.name = name;
        if (isBusiness) {
            wallet = new BusinessWallet(1000, 500); 
        } else {
            wallet = new PersonalWallet(100); 
        }
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

public class EWalletDemo {
    public static void main(String[] args) {
        User u1 = new User("U101", "Alice", false);
        User u2 = new User("U201", "Bob", true);

        u1.getWallet().addMoney(200);
        u2.getWallet().addMoney(500);

        u1.getWallet().transferTo(u2, 150);
        u2.getWallet().transferTo(u1, 300);

        System.out.println("Alice Wallet Balance: $" + u1.getWallet().getBalance());
        System.out.println("Bob Wallet Balance: $" + u2.getWallet().getBalance());

        System.out.println("Alice Transaction History:");
        u1.getWallet().showHistory();

        System.out.println("Bob Transaction History:");
        u2.getWallet().showHistory();
    }
}
