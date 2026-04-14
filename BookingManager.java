import java.io.*;
import java.util.*;


public class BookingManager implements Bookable, AdvancedDisplay {
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) throws Exception {
        for (Booking b : bookings) {
            if (b.getRoomNumber() == booking.getRoomNumber() &&
                b.getDate().equals(booking.getDate())) {
                throw new DuplicateBookingException("Room already booked!");
            }
        }
        bookings.add(booking);
    }
    
        public void saveObject() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("booking.ser"))) {

            oos.writeObject(bookings);

        } catch (IOException e) {
            System.out.println("Error saving object");
        }
    }
    
        @SuppressWarnings("unchecked")
    public void loadObject() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("booking.ser"))) {

            bookings = (ArrayList<Booking>) ois.readObject();

        } catch (Exception e) {
            System.out.println("No saved object data");
        }
    }
    
    public void cancelBooking(String bookingID) throws Exception {
        Booking found = null;

        for (Booking b : bookings) {
            if (b.getBookingID().equals(bookingID)) {
                found = b;
                break;
            }
        }

        if (found == null) {
            throw new Exception("Booking not found!");
        }

        bookings.remove(found);
    }

    public Booking searchBooking(String id) {
        for (Booking b : bookings) {
            if (b.getBookingID().equals(id)) return b;
        }
        return null;
    }

    public void displayBookings() {
        for (Booking b : bookings) {
            System.out.println(b.display());
        }
    }

    public void displayDetailedBookings() {
        displayBookings();
    }

    // SAVE FILE
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("booking.txt"))) {
            for (Booking b : bookings) {
                bw.write(b.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    // LOAD FILE
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("booking.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                bookings.add(new Booking(data[1],
                        Integer.parseInt(data[2]),
                        data[3]));
            }
        } catch (IOException e) {
            System.out.println("No previous data");
        }
    }
}