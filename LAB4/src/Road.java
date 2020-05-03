import vehicle.Cars;
import vehicle.Vehicles;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicles> VehicleOnRoad = new ArrayList<>();

    public int GetAmountOnRoadHuman() {
        int humanAmount = VehicleOnRoad.stream().mapToInt(Vehicles::getSeatingOccupied).sum();
        return humanAmount;
    }

    public int GetAmountOnRoadVehicle() {
        return VehicleOnRoad.size();
    }

    public <T extends  Vehicles> void AddVehicleOnRoad(T new_vehicle) {
        if (new_vehicle == null)
            return;
        VehicleOnRoad.add(new_vehicle);
    }
}
