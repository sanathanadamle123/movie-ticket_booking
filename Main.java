import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystem bs = new BookingSystem(5, 8); // 5 rows, 8 columns

        while (true) {
            System.out.println("\n=== Movie Ticket Booking System ===");
            System.out.println("1. Show seat layout");
            System.out.println("2. Book seat");
            System.out.println("3. Cancel booking");
            System.out.println("4. Show bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = -1;
            try { ch = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { ch = -1; }

            switch (ch) {
                case 1:
                    bs.displaySeats();
                    break;
                case 2:
                    System.out.print("Enter row number: ");
                    int r = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter column number: ");
                    int c = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Customer name: ");
                    String name = sc.nextLine().trim();
                    if (!bs.book(r, c, name)) {
                        System.out.println("Booking failed. Seat may be already booked or invalid.");
                    }
                    break;
                case 3:
                    System.out.print("Enter row number to cancel: ");
                    int cr = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter column number to cancel: ");
                    int cc = Integer.parseInt(sc.nextLine().trim());
                    if (!bs.cancel(cr, cc)) {
                        System.out.println("Cancel failed. Seat not booked or invalid.");
                    }
                    break;
                case 4:
                    bs.showBookings();
                    break;
                case 5:
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
