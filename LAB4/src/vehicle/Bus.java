package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;

public class Bus extends Vehicle {
    private String companyOwner;
    private int luggageCompartmentVolume;

    public Bus(String carBrand, String stateVehicleNumber, int seatingAvailable, String companyOwner, int luggageCompartmentVolume) {
        super(carBrand, stateVehicleNumber, seatingAvailable);
        this.companyOwner = companyOwner;
        this.luggageCompartmentVolume = luggageCompartmentVolume;
    }
}
