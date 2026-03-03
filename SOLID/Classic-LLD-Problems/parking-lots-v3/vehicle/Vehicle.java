package vehicle;

public abstract class Vehicle {
    private String licenseNumber;
    private VehicleSize VehicleType;

    public Vehicle(String licenseNumber, VehicleSize vehicleType) {
        this.licenseNumber = licenseNumber;
        this.VehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleSize getVehicleType() {
        return VehicleType;
    }
}
