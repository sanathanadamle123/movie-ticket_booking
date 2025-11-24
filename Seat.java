public class Seat {
    private int row;
    private int col;
    private boolean booked;

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.booked = false;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isBooked() { return booked; }

    public void book() { this.booked = true; }
    public void cancel() { this.booked = false; }

    @Override
    public String toString() {
        return "[" + row + "-" + col + "] " + (booked ? "X" : "O");
    }
}
