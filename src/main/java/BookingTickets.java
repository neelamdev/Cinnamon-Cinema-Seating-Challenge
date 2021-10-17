import java.util.List;

public class BookingTickets {
    static int iterator = 0;
    int totalSeat;
    List<String> totalSeatsAvailable;

    public BookingTickets() { }

    public BookingTickets(List<String> seatsAvailableList) {
        this.totalSeatsAvailable = seatsAvailableList;
        this.totalSeat = seatsAvailableList.size();
    }

    public synchronized void allocateTickets(String userName, int numberOfTickets) {
        if (numberOfTickets < 1 || numberOfTickets > 3)
            throw new IllegalArgumentException("please enter tickets between 1 and 3");

        if (totalSeat >= numberOfTickets) {
            System.out.println("Hi! " + userName + "  your " + numberOfTickets + " tickets are booked " +
                    "successfully and reserved seats for you are :");
            totalSeat = totalSeat - numberOfTickets;}
         else {
            System.out.println("Sorry! " + userName + "   All Seats are Booked for this show,please try next show");
            throw new IllegalArgumentException("All Seats are Booked for this show,please try next show");}

         for (; numberOfTickets > 0; numberOfTickets--) {
            if (iterator < totalSeatsAvailable.size())
                System.out.println(totalSeatsAvailable.get(iterator));
            iterator++;}

    }
}




