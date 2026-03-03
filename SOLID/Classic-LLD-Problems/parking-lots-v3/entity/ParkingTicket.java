package entity;

import java.util.Date;
import java.util.UUID;

import vehicle.Vehicle;

public class ParkingTicket {

    private String ticketId;
    private ParkingSpot spot;
    private long entryTime;
    private long exitTime;
    private Vehicle vehicle;

    public ParkingTicket(ParkingSpot spot, Vehicle vehicle) {
        this.ticketId = UUID.randomUUID().toString();
        this.spot = spot;
        this.entryTime = new Date().getTime();
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }

    
}