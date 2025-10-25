interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refunded $" + amount + " using default method.");
    }
}

class PayPal implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal");
    }
}

class CreditCard implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }
}

public class PaymentTest1 {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPal();
        PaymentProcessor card = new CreditCard();

        paypal.pay(100);
        paypal.refund(50);

        card.pay(200);
        card.refund(75);
    }
}
