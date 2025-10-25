interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using UPI");
    }
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card");
    }
}

class Wallet implements Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Wallet");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        Payment upi = new UPI();
        Payment card = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(150.0);
        card.pay(300.0);
        wallet.pay(50.0);
    }
}
