package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Humans;

import java.util.ArrayList;
import java.util.List;

public class Vehicles<T extends Humans> {
    public Vehicles(String carBrand, String stateVehicleNumber, int seatingAvailable) {
        CarBrand = carBrand;
        StateVehicleNumber = stateVehicleNumber;
        SeatingAvailable = seatingAvailable;
    }

    public String CarBrand;
    public String StateVehicleNumber;

    protected int SeatingAvailable;
    protected int SeatingOccupied;

    public int getSeatingAvailable() {
        return SeatingAvailable;
    }
    public int getSeatingOccupied() {
        return SeatingOccupied;
    }

    protected List<T> passengerList = new ArrayList<>();

    public void NewPassenger(T passenger) throws VehicleFull, HumanExisting {
        if (passenger == null)
            return;
        if (getSeatingAvailable() == getSeatingOccupied())
            throw new VehicleFull("Passenger " + passenger.Surname + " can not be new. Vehicle full");
        if (passengerList.contains(passenger))
            throw new HumanExisting("Passenger " + passenger.Surname + " is already inside a vehicle");
        passengerList.add(passenger);
        SeatingOccupied++;
    }

    public void PassengerLeave(T passenger) throws HumanExisting {
        if (passenger == null)
            return;
        if (!passengerList.contains(passenger))
            throw new HumanExisting("Passenger " + passenger.Surname + " is not inside a vehicle");
        passengerList.remove(passenger);
    }
}
