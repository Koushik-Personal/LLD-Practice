package SOLID.Fundamentals_Practice.SRP.MovieTicketBooking;

public class MovieTicketGSTCalculation {
    private final double gstPercentage;
    private final double basePrice;

    public MovieTicketGSTCalculation(double gstPercentage, double basePrice) {
        this.gstPercentage = gstPercentage;
        this.basePrice = basePrice;
    }

    public double calculatePrice() {
        return basePrice + (basePrice * gstPercentage / 100);
    }
}
