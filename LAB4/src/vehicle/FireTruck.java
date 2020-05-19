package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Firefighter;

public class FireTruck extends Car<Firefighter> {
    private int waterTuckCapacity;
    private int ladderLength;

    public FireTruck(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, int waterTuckCapacity, int ladderLength) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.waterTuckCapacity = waterTuckCapacity;
        this.ladderLength = ladderLength;
    }
}
