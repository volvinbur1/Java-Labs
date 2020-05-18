package vehicle;

import humans.Human;

public class Car<T extends Human> extends Vehicle<T> {
    public int trunkVolume;
    public Car(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume) {
        super(carBrand, stateVehicleNumber, seatingAvailable);
        this.trunkVolume = trunkVolume;
    }
}