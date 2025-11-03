

class SeatUnavailableException extends Exception {
    public SeatUnavailableException(String message) {
        super(message);
    }
}


class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}


public class FlightBookingApplication {

    
    public static void checkSeatAvailability() throws SeatUnavailableException {
        
        if (Math.random() < 0.5) {
            throw new SeatUnavailableException("❌ Seat unavailable! Please choose a different flight or seat.");
        }
        System.out.println("✅ Seat is available.");
    }

    
    public static void processPayment() throws PaymentFailedException {
        
        if (Math.random() < 0.5) {
            throw new PaymentFailedException(" Payment failed! Please check your card or try again later.");
        }
        System.out.println("💳 Payment processed successfully.");
    }


    public static void bookTicket() throws Exception {
        checkSeatAvailability(); 
        processPayment();        
        System.out.println("🎫 Flight ticket booked successfully!");
    }

    
    public static void main(String[] args) {
        System.out.println("=== ✈️ Flight Booking Application ===");

        try {
            bookTicket();
        } 
        catch (SeatUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (PaymentFailedException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } 
        finally {
            System.out.println("Thank you for booking with us!");
        }
    }
}

