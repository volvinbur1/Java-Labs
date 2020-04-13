package vehicle;

public class Taxi extends Cars {
    private int tariff;
    private String brandName;

    public Taxi(String carBrand, String stateVehicleNumber, int seatingAvailable, int trunkVolume, int tariff, String brandName) {
        super(carBrand, stateVehicleNumber, seatingAvailable, trunkVolume);
        this.tariff = tariff;
        this.brandName = brandName;
    }
}
