import java.io.Serializable;

public class Booking implements Serializable {
    private static int totalBookings = 0;

    static {
        System.out.println("Booking system initialized");
    }
    
    private String bookingID;
    private String customerName;
    private int roomNumber;
    private String date;

    public Booking(String customerName, int roomNumber, String date) {
        this.bookingID = generateBookingID();
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.date = date;
    }

    public static String generateBookingID() {
        totalBookings++;
        return "B" + totalBookings;
    }

    public String getBookingID() { return bookingID; }
    public String getCustomerName() { return customerName; }
    public int getRoomNumber() { return roomNumber; }
    public String getDate() { return date; }

    public void setCustomerName(String name) { this.customerName = name; }
    public void setDate(String date) { this.date = date; }

    public String display() {
        return "ID: " + bookingID + " | Name: " + customerName +
               " | Room: " + roomNumber + " | Date: " + date;
    }

    public String toFileString() {
        return bookingID + "," + customerName + "," + roomNumber + "," + date;
    }
}