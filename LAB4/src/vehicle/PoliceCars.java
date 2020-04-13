package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Humans;
import humans.Policemen;

public class PoliceCars extends Cars {
    private String department;
    private String purposeOfCar;

    public PoliceCars(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, String department, String purposeOfCar) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.department = department;
        this.purposeOfCar = purposeOfCar;
    }

    @Override
    public <T extends Humans> void NewPassenger(T passenger) throws VehicleFull, HumanExisting {
        if (passenger == null)
            return;
        if(!(passenger instanceof Policemen))
            return;
        if (getSeatingAvailable() == getSeatingOccupied())
            throw new VehicleFull("Policeman " + passenger.Surname + " can not be new. Police car full");
        if (passengerList.contains(passenger))
            throw new HumanExisting("Policeman " + passenger.Surname + " is already inside a police car");
        SeatingOccupied++;
    }

    @Override
    public <T extends Humans> void PassengerLeave(T passenger) throws HumanExisting {
        if (passenger == null)
            return;
        if(!(passenger instanceof Policemen))
            return;
        if (!passengerList.contains(passenger))
            throw new HumanExisting("Policeman " + passenger.Surname + " is not inside a police car");
        passengerList.remove(passenger);
    }
}
