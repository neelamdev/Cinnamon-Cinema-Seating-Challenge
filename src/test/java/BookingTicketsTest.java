import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookingTicketsTest {

    @Test
    public void WhenAskForTicketsGreaterThenThreeThenThrowException() {
        //arrange
        BookingTickets booking = new BookingTickets();
        //act and catch exception
        assertThrows(IllegalArgumentException.class, () -> booking.allocateTickets("John", 4));
    }

    @Test
    public void WhenAskForTicketsLessThenOneThenThrowException() {
        //arrange
        BookingTickets booking = new BookingTickets();
        //act and catch exception
        assertThrows(IllegalArgumentException.class, () -> booking.allocateTickets("John", 0));
    }

    @Test
    public void WhenAllTicketsBookedThenThrowException() {
        List<String> availableList = List.of("A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5");
        //arrange
        BookingTickets booking = new BookingTickets(availableList);

        //act and gracefully catch exception if all seats are booked
        booking.allocateTickets("John", 3);
        booking.allocateTickets("John", 3);
        booking.allocateTickets("John", 3);
        booking.allocateTickets("John", 3);
        booking.allocateTickets("John", 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> booking.allocateTickets("John", 2)
                , "All Seats are Booked for this show,please try next show");
    }

    @Test
    public void WhenTwoUserAskForSameTicketsThenLockTickets() {
        //arrange
        List<String> availableList = List.of("A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5");

        BookingTickets booking = new BookingTickets(availableList);
        BookingTicketsThread thread1 = new BookingTicketsThread(booking, "John", 2);
        BookingTicketsThread thread2 = new BookingTicketsThread(booking, "Martin", 2);

        //act and gracefully catch exception if all seats are booked
        booking.allocateTickets("John", 3);
        booking.allocateTickets("Martin", 3);
        booking.allocateTickets("John", 3);
        booking.allocateTickets("Martin", 3);
        thread1.start();

        Assertions.assertThrows(IllegalArgumentException.class, () -> thread2.run());

    }

}
