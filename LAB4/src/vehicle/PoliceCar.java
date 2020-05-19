package vehicle;

import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Policeman;

public class PoliceCar extends Car<Policeman> {
    private String department;
    private String purposeOfCar;

    public PoliceCar(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, String department, String purposeOfCar) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.department = department;
        this.purposeOfCar = purposeOfCar;
    }
}
