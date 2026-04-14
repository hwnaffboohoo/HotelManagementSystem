public interface Bookable {
    void addBooking(Booking booking) throws Exception;
    void cancelBooking(String bookingID) throws Exception;
}