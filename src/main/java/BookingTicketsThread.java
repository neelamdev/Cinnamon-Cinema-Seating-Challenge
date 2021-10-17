public class BookingTicketsThread extends Thread{
    private BookingTickets bookingTickets;
    private String userName;
    private int numberOfTicketsRequired;

    public BookingTicketsThread(BookingTickets booking, String userName, int numberOfTickets) {
        this.bookingTickets=booking;
        this.userName=userName;
        this.numberOfTicketsRequired=numberOfTickets;
    }
    @Override
    public void run(){
        bookingTickets.allocateTickets(userName,numberOfTicketsRequired);
    }
}
