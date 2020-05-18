import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Firefighters;
import humans.Humans;
import humans.Policemen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import vehicle.Buses;
import vehicle.PoliceCars;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void PeoplesInBuss() throws VehicleFull, HumanExisting {
        Buses bus = new Buses("MAN", "AB4674DB", 18, "Siti", 40);
        for (int a = 0; a < 6; a++) {
            Humans human = new Humans("name" + a, "surname"+a, "middleName" + a, 18 + a);
            bus.NewPassenger(human);
        }
        for (int a = 6; a < 12; a++) {
            Policemen policeman = new Policemen("name" + a, "surname"+a, "middleName" + a, 18 + a,
                    "department"+a, "major", 100+a);
            bus.NewPassenger(policeman);
        }
        for (int a = 12; a < 18; a++) {
            Firefighters human = new Firefighters("name" + a, "surname"+a, "middleName" + a, 18 + a,
                    "department" + a, "major");
            bus.NewPassenger(human);
        }
        assertEquals(18, bus.getSeatingOccupied());
    }

    @Test
    void AddToFullBuss() {
        Buses bus = new Buses("MAN", "AB4674DB", 10, "Siti", 40);
        assertThrows(VehicleFull.class, () -> {
            for (int a = 0; a < 20; a++) {
                Humans human = new Humans("name" + a, "surname" + a, "middleName" + a, 18 + a);
                bus.NewPassenger(human);
            }
        });
    }

    @Test
    void AddingExistingPassenger() {
        Buses bus = new Buses("MAN", "AB4674DB", 10, "Siti", 40);
        Humans human = new Humans("name", "surname", "middleName", 18);
        assertThrows(HumanExisting.class, () -> {
            bus.NewPassenger(human);
            bus.NewPassenger(human);
        });
    }

    @Test
    void policeManInPoliceCar() throws VehicleFull, HumanExisting {
        PoliceCars policeCar = new PoliceCars("Ford", "1234", 2,
                60, "Department", "patrol");
        Policemen policeman = new Policemen("name", "surname", "middleName", 40,
                    "Department", "major", 15484);
        Policemen policeman1 = new Policemen("name1", "surname1", "middleName", 40,
                "Department", "major", 15484);
        policeCar.NewPassenger(policeman);
        policeCar.NewPassenger(policeman1);
        assertEquals(2, policeCar.getSeatingOccupied());
    }

    @Test
    void GetHumansOnRoad() throws VehicleFull, HumanExisting {
        PoliceCars policeCar = new PoliceCars("Ford", "1234", 2,
                60, "Department", "patrol");
        Buses bus = new Buses("MAN", "AB4674DB", 10,
                "Siti", 40);
        Policemen policeman1 = new Policemen("name1", "surname1", "middleName1", 40,
                "Department1", "major1", 15481);
        Policemen policeman2 = new Policemen("name2", "surname2", "middleName2", 40,
                "Department2", "major2", 15482);
        policeCar.NewPassenger(policeman1);
        policeCar.NewPassenger(policeman2);
        for (int a = 0; a < 10; a++) {
            Humans human = new Humans("name" + a, "surname" + a, "middleName" + a, 18 + a);
            bus.NewPassenger(human);
        }

        Road road = new Road();
        road.AddVehicleOnRoad(policeCar);
        road.AddVehicleOnRoad(bus);
        assertEquals(12, road.GetAmountOnRoadHuman());
    }

    @Test
    void GetVehiclesOnRoad() throws VehicleFull, HumanExisting {
        PoliceCars policeCar = new PoliceCars("Ford", "1234",
                2, 60, "Department", "patrol");
        Buses bus = new Buses("MAN", "AB4674DB", 10,
                "Siti", 40);
        Policemen policeman1 = new Policemen("name1", "surname1", "middleName1", 40,
                "Department1", "major1", 15481);
        Policemen policeman2 = new Policemen("name2", "surname2", "middleName2", 40,
                "Department2", "major2", 15482);
        policeCar.NewPassenger(policeman1);
        policeCar.NewPassenger(policeman2);
        for (int a = 0; a < 10; a++) {
            Humans human = new Humans("name" + a, "surname" + a, "middleName" + a, 18 + a);
            bus.NewPassenger(human);
        }
        Road road = new Road();
        road.AddVehicleOnRoad(policeCar);
        road.AddVehicleOnRoad(bus);
        assertEquals(2, road.GetAmountOnRoadVehicle());
    }
}