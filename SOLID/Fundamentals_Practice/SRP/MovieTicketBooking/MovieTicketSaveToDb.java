package SOLID.Fundamentals_Practice.SRP.MovieTicketBooking;

public class MovieTicketSaveToDb implements SavaToDb {

    private final TicketInformation ticketInformation;

    public MovieTicketSaveToDb(TicketInformation ticketInformation) {
        this.ticketInformation = ticketInformation;
    }

    @Override
    public void save() {
        System.out.println("Saving movie ticket booking details to database." + ticketInformation.toString());
    }
    
}
