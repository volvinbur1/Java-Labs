import exceptions.HumanExisting;
import exceptions.VehicleFull;
import humans.Firefighter;
import humans.Human;
import humans.Policeman;
import org.junit.jupiter.api.Test;
import vehicle.Bus;
import vehicle.PoliceCar;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void PeoplesInBuss() throws VehicleFull, HumanExisting {
        Bus bus = new Bus("MAN", "AB4674DB", 18, "Siti", 40);
        for (int a = 0; a < 6; a++) {
            Human human = new Human("name" + a, "surname"+a, "middleName" + a, 18 + a);
            bus.addPassenger(human);
        }
        for (int a = 6; a < 12; a++) {
            Policeman policeman = new Policeman("name" + a, "surname"+a, "middleName" + a, 18 + a,
                    "department"+a, "major", 100+a);
            bus.addPassenger(policeman);
        }
        for (int a = 12; a < 18; a++) {
            Firefighter human = new Firefighter("name" + a, "surname"+a, "middleName" + a, 18 + a,
                    "department" + a, "major");
            bus.addPassenger(human);
        }
        assertEquals(18, bus.getSeatingOccupied());
    }

    @Test
    void AddToFullBuss() {
        Bus bus = new Bus("MAN", "AB4674DB", 10, "Siti", 40);
        assertThrows(VehicleFull.class, () -> {
            for (int a = 0; a < 20; a++) {
                Human human = new Human("name" + a, "surname" + a, "middleName" + a, 18 + a);
                bus.addPassenger(human);
            }
        });
    }

    @Test
    void AddingExistingPassenger() {
        Bus bus = new Bus("MAN", "AB4674DB", 10, "Siti", 40);
        Human human = new Human("name", "surname", "middleName", 18);
        assertThrows(HumanExisting.class, () -> {
            bus.addPassenger(human);
            bus.addPassenger(human);
        });
    }

    @Test
    void policeManInPoliceCar() throws VehicleFull, HumanExisting {
        PoliceCar policeCar = new PoliceCar("Ford", "1234", 2,
                60, "Department", "patrol");
        Policeman policeman = new Policeman("name", "surname", "middleName", 40,
                    "Department", "major", 15484);
        Policeman policeman1 = new Policeman("name1", "surname1", "middleName", 40,
                "Department", "major", 15484);
        policeCar.addPassenger(policeman);
        policeCar.addPassenger(policeman1);
        assertEquals(2, policeCar.getSeatingOccupied());
    }

    @Test
    void GetHumanOnRoad() throws VehicleFull, HumanExisting {
        PoliceCar policeCar = new PoliceCar("Ford", "1234", 2,
                60, "Department", "patrol");
        Bus bus = new Bus("MAN", "AB4674DB", 10,
                "Siti", 40);
        Policeman policeman1 = new Policeman("name1", "surname1", "middleName1", 40,
                "Department1", "major1", 15481);
        Policeman policeman2 = new Policeman("name2", "surname2", "middleName2", 40,
                "Department2", "major2", 15482);
        policeCar.addPassenger(policeman1);
        policeCar.addPassenger(policeman2);
        for (int a = 0; a < 10; a++) {
            Human human = new Human("name" + a, "surname" + a, "middleName" + a, 18 + a);
            bus.addPassenger(human);
        }

        Road road = new Road();
        road.AddVehicleOnRoad(policeCar);
        road.AddVehicleOnRoad(bus);
        assertEquals(12, road.GetAmountOnRoadHuman());
    }

    @Test
    void GetVehiclesOnRoad() throws VehicleFull, HumanExisting {
        PoliceCar policeCar = new PoliceCar("Ford", "1234",
                2, 60, "Department", "patrol");
        Bus bus = new Bus("MAN", "AB4674DB", 10,
                "Siti", 40);
        Policeman policeman1 = new Policeman("name1", "surname1", "middleName1", 40,
                "Department1", "major1", 15481);
        Policeman policeman2 = new Policeman("name2", "surname2", "middleName2", 40,
                "Department2", "major2", 15482);
        policeCar.addPassenger(policeman1);
        policeCar.addPassenger(policeman2);
        for (int a = 0; a < 10; a++) {
            Human human = new Human("name" + a, "surname" + a, "middleName" + a, 18 + a);
            bus.addPassenger(human);
        }
        Road road = new Road();
        road.AddVehicleOnRoad(policeCar);
        road.AddVehicleOnRoad(bus);
        assertEquals(2, road.GetAmountOnRoadVehicle());
    }
}