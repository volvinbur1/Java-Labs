package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Humans;
import humans.Policemen;

public class PoliceCars extends Cars<Policemen> {
    private String department;
    private String purposeOfCar;

    public PoliceCars(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, String department, String purposeOfCar) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.department = department;
        this.purposeOfCar = purposeOfCar;
    }
}
