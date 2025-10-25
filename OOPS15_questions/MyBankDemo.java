interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

abstract class Account implements ITransaction {
    protected String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void calculateInterest();

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " to account " + accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance in account " + accountNumber);
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate = 5.0;

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest of $" + interest + " added to Savings Account " + accountNumber);
    }
}

class CurrentAccount extends Account {
    private double interestRate = 2.0;

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest of $" + interest + " added to Current Account " + accountNumber);
    }
}

public class MyBankDemo {
    public static void main(String[] args) {
        Account sa1 = new SavingsAccount("SAV001", 1000);
        Account ca1 = new CurrentAccount("CUR001", 500);

        sa1.deposit(500);
        ca1.deposit(200);

        sa1.withdraw(200);
        ca1.withdraw(700);

        sa1.calculateInterest();
        ca1.calculateInterest();

        System.out.println("Savings Account Balance: $" + sa1.checkBalance());
        System.out.println("Current Account Balance: $" + ca1.checkBalance());
    }
}
