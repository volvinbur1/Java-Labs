package vehicle;

import humans.Humans;

public class Cars extends Vehicles {
    public int trunkVolume;
    public Cars (String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume) {
        super(carBrand, stateVehicleNumber, seatingAvailable);
        this.trunkVolume = trunkVolume;
    }
}