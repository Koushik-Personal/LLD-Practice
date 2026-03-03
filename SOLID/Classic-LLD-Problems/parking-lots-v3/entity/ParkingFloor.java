package entity;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import vehicle.Vehicle;
import vehicle.VehicleSize;

public class ParkingFloor {
    private String floorId;
    private Map<String, ParkingSpot> spots;

    public ParkingFloor(String floorId, Map<String, ParkingSpot> parkingSpots) {
        this.floorId = floorId;
        this.spots = new ConcurrentHashMap<>();
    }

    public String getFloorId() {
        return floorId;
    }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
        return spots.values().stream()
                .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotSize))
                .findFirst();
    }

    public void displayAvailability() {
        System.out.printf("--- Floor %d Availability ---\n", floorId);
        Map<VehicleSize, Long> availableCounts = spots.values().stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));

        for (VehicleSize size : VehicleSize.values()) {
            System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }


}
