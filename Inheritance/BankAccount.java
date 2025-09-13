class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayDetails();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int tenureMonths;

    FixedDepositAccount(String accountNumber, double balance, int tenureMonths) {
        super(accountNumber, balance);
        this.tenureMonths = tenureMonths;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayDetails();
        System.out.println("Tenure: " + tenureMonths + " months");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000.00, 4.5);
        savings.displayAccountType();

        System.out.println();

        CheckingAccount checking = new CheckingAccount("CA456", 3000.00, 1000.00);
        checking.displayAccountType();

        System.out.println();

        FixedDepositAccount fixed = new FixedDepositAccount("FD789", 20000.00, 24);
        fixed.displayAccountType();
    }
}
