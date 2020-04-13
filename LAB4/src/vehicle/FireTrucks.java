package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Firefighters;
import humans.Humans;
import humans.Policemen;

public class FireTrucks extends Cars {
    private int waterTuckCapacity;
    private int ladderLength;

    public FireTrucks(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, int waterTuckCapacity, int ladderLength) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.waterTuckCapacity = waterTuckCapacity;
        this.ladderLength = ladderLength;
    }

    @Override
    public <T extends Humans> void NewPassenger(T passenger) throws VehicleFull, HumanExisting {
        if (passenger == null)
            return;
        if(!(passenger instanceof Firefighters))
            return;
        if (getSeatingAvailable() == getSeatingOccupied())
            throw new VehicleFull("Firefighter " + passenger.Surname + " can not be new. Fire truck full");
        if (passengerList.contains(passenger))
            throw new HumanExisting("Firefighter " + passenger.Surname + " is already inside a Fire truck");
        SeatingOccupied++;
    }

    @Override
    public <T extends Humans> void PassengerLeave(T passenger) throws HumanExisting {
        if (passenger == null)
            return;
        if(!(passenger instanceof Firefighters))
            return;
        if (!passengerList.contains(passenger))
            throw new HumanExisting("Firefighter " + passenger.Surname + " is not inside a Fire truck");
        passengerList.remove(passenger);
    }
}
