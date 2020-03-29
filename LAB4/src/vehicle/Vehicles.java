package vehicle;

public class Vehicles {
    public String CarBrand;
    public String StateVehicleNumber;

    protected int SeatingAvailable;
    protected int SeatingOccupied;

    public void setSeatingAvailable(int seatingAvailable) {
        SeatingAvailable = seatingAvailable;
    }
    public void setSeatingOccupied(int seatingOccupied) {
        SeatingOccupied = seatingOccupied;
    }

    public int getSeatingAvailable() {
        return SeatingAvailable;
    }
    public int getSeatingOccupied() {
        return SeatingOccupied;
    }
}
