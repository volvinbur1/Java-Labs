package vehicle;

import humans.Humans;

public class Cars<T extends Humans> extends Vehicles<T> {
    public int trunkVolume;
    public Cars (String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume) {
        super(carBrand, stateVehicleNumber, seatingAvailable);
        this.trunkVolume = trunkVolume;
    }
}