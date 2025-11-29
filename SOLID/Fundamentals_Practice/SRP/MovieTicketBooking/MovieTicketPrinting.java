package SOLID.Fundamentals_Practice.SRP.MovieTicketBooking;

public class MovieTicketPrinting implements Printing {

    private TicketInformation ticketInfo;

    public MovieTicketPrinting(TicketInformation ticketInfo) {
        this.ticketInfo = ticketInfo;
    }
    @Override
    public void print() {
        System.out.println("Movie Ticket Details:");
        System.out.println("Movie Name: " + ticketInfo.getMovieName());
        System.out.println("Seat Number: " + ticketInfo.getSeatNumber());
        System.out.println("Ticket Price: " + ticketInfo.getTicketPrice());
        System.out.println("Theater Name: " + ticketInfo.getTheaterName());
        System.out.println("Show Time: " + ticketInfo.getShowTime());
    }
    
}
