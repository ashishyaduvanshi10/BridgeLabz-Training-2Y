import java.util.Random;


class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}


class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}


public class OnlineOrderProcessing {


    public static void placeOrder() throws OutOfStockException, PaymentFailedException {
        Random random = new Random();
        int outcome = random.nextInt(3); 

        if (outcome == 0) {
            throw new OutOfStockException(" Product is out of stock!");
        } else if (outcome == 1) {
            throw new PaymentFailedException(" Payment failed! Please try again.");
        } else {
            System.out.println(" Order placed successfully! Thank you for shopping with us.");
        }
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("=== Online Order Processing System ===");

        try {
            placeOrder();
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for visiting our online store!");
        }
    }
}
