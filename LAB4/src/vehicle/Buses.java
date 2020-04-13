package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Humans;

public class Buses extends Vehicles {
    private String companyOwner;
    private int luggageCompartmentVolume;

    public Buses(String carBrand, String stateVehicleNumber, int seatingAvailable, String companyOwner, int luggageCompartmentVolume) {
        super(carBrand, stateVehicleNumber, seatingAvailable);
        this.companyOwner = companyOwner;
        this.luggageCompartmentVolume = luggageCompartmentVolume;
    }
}
