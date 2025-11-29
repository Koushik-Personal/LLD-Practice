package SOLID.Fundamentals_Practice.SRP.MovieTicketBooking;

public class TicketInformation {
    private String movieName;
    private String theaterName;
    private String showTime;
    private int seatNumber;
    private double ticketPrice;

    public TicketInformation(String movieName, String theaterName, String showTime, int seatNumber,
            double ticketPrice) {
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.showTime = showTime;
        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}


