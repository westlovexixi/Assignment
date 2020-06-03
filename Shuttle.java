public class Shuttle {
    private String shuttleId;
    private String Name;
    private String year;
    private double fuelCapacity;
    private double passenger;
    private double cargoCap;
    private double speed;
    private String origin;

    public Shuttle(String shuttleId, String name, String year, double fuelCapacity, double passenger, double cargoCap, double speed, String origin) {
        this.shuttleId = shuttleId;
        Name = name;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.passenger = passenger;
        this.cargoCap = cargoCap;
        this.speed = speed;
        this.origin = origin;
    }

    public Shuttle() {

    }

    public String getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(String shuttleId) {
        this.shuttleId = shuttleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getPassenger() {
        return passenger;
    }

    public void setPassenger(double passenger) {
        this.passenger = passenger;
    }

    public double getCargoCap() {
        return cargoCap;
    }

    public void setCargoCap(double cargoCap) {
        this.cargoCap = cargoCap;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
