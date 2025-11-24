import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
    private Theater theater;
    private Map<String, String> bookings; // key: seat code "r-c", value: customer name

    public BookingSystem(int rows, int cols) {
        theater = new Theater(rows, cols);
        bookings = new HashMap<>();
    }

    public boolean book(int r, int c, String customer) {
        boolean ok = theater.bookSeat(r, c);
        if (!ok) return false;
        bookings.put(r + "-" + c, customer);
        System.out.println("Seat " + r + "-" + c + " booked for " + customer);
        return true;
    }

    public boolean cancel(int r, int c) {
        boolean ok = theater.cancelSeat(r, c);
        if (!ok) return false;
        bookings.remove(r + "-" + c);
        System.out.println("Seat " + r + "-" + c + " booking cancelled.");
        return true;
    }

    public void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        System.out.println("\nCurrent bookings:");
        for (var entry : bookings.entrySet()) {
            System.out.println("Seat " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displaySeats() {
        theater.displaySeats();
    }
}
