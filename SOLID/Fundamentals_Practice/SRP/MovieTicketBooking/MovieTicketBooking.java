package SOLID.Fundamentals_Practice.SRP.MovieTicketBooking;

public class MovieTicketBooking {
    public static void main(String[] args) {
        
        TicketInformation ticket = new TicketInformation(
                "Inception",
                "IMAX Theater",
                "7:00 PM",
                42,
                15.00
            );
        MovieTicketPriceCalculation priceCalculation = new MovieTicketPriceCalculation(ticket);
        priceCalculation.calculatePrice();
        MovieTicketPrinting printing = new MovieTicketPrinting(ticket);
        printing.print();
        MovieTicketSaveToDb saveToDb = new MovieTicketSaveToDb(ticket);
        saveToDb.save();
    }
}