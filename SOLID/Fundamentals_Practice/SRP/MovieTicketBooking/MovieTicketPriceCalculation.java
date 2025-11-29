package SOLID.Fundamentals_Practice.SRP.MovieTicketBooking;

public class MovieTicketPriceCalculation implements PriceCalculation {

    private TicketInformation ticketInformation;

    public MovieTicketPriceCalculation(TicketInformation ticketInformation) {
        this.ticketInformation = ticketInformation;
    }

    @Override
    public double calculatePrice() {
        
        double priceWithGst = new MovieTicketGSTCalculation(15, ticketInformation.getTicketPrice()).calculatePrice()  ;
        ticketInformation.setTicketPrice(priceWithGst);
        return priceWithGst;
    }

    
}