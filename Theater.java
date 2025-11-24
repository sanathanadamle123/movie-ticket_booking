public class Theater {
    private Seat[][] seats;
    private int rows;
    private int cols;

    public Theater(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seats = new Seat[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                seats[r][c] = new Seat(r+1, c+1);
            }
        }
    }

    public boolean bookSeat(int r, int c) {
        if (r < 1 || r > rows || c < 1 || c > cols) return false;
        Seat s = seats[r-1][c-1];
        if (s.isBooked()) return false;
        s.book();
        return true;
    }

    public boolean cancelSeat(int r, int c) {
        if (r < 1 || r > rows || c < 1 || c > cols) return false;
        Seat s = seats[r-1][c-1];
        if (!s.isBooked()) return false;
        s.cancel();
        return true;
    }

    public void displaySeats() {
        System.out.println("\nSeat layout (O = available, X = booked):");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(seats[r][c].isBooked() ? " X " : " O ");
            }
            System.out.println();
        }
    }

    public int getTotalSeats() { return rows * cols; }
}
