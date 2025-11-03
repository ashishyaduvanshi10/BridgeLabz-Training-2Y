import java.util.*;

class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}


class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}


public class MovieTicketBooking {

    
    private static Map<Integer, Boolean> seats = new HashMap<>();

    
    static {
        for (int i = 1; i <= 10; i++) {
            seats.put(i, true); 
        }
    }

    public static void bookSeat(int seatNumber)
            throws InvalidSeatException, SeatAlreadyBookedException {


        if (!seats.containsKey(seatNumber)) {
            throw new InvalidSeatException(" Invalid seat number! Please choose between 1 and 10.");
        }

        
        if (!seats.get(seatNumber)) {
            throw new SeatAlreadyBookedException(" Seat " + seatNumber + " is already booked!");
        }


        seats.put(seatNumber, false);
        System.out.println(" Seat " + seatNumber + " booked successfully!");
    }


    public static void showAvailableSeats() {
        System.out.println("\n=== Available Seats ===");
        for (int i = 1; i <= 10; i++) {
            String status = seats.get(i) ? "Available " : "Booked ";
            System.out.println("Seat " + i + ": " + status);
        }
        System.out.println();
    }

    // 🔹 Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===  Movie Ticket Booking System ===");
        showAvailableSeats();

        try {
            
            System.out.print("Enter seat number to book: ");
            int seat1 = sc.nextInt();
            bookSeat(seat1);

            
            System.out.print("Enter seat number to book again: ");
            int seat2 = sc.nextInt();
            bookSeat(seat2);

            
            System.out.print("Enter invalid seat number: ");
            int seat3 = sc.nextInt();
            bookSeat(seat3);

        } catch (InvalidSeatException | SeatAlreadyBookedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a number.");
        } finally {
            showAvailableSeats();
            System.out.println(" Thank you for using the Movie Ticket Booking System!");
            sc.close();
        }
    }
}
