package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Firefighters;
import humans.Humans;
import humans.Policemen;

public class FireTrucks extends Cars<Firefighters> {
    private int waterTuckCapacity;
    private int ladderLength;

    public FireTrucks(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, int waterTuckCapacity, int ladderLength) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.waterTuckCapacity = waterTuckCapacity;
        this.ladderLength = ladderLength;
    }
}
