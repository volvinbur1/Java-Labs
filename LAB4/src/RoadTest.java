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
    void PeoplesInBuss() {
        Buses bus = new Buses("MAN", "AB4674DB", 18, "Siti", 40);
        for (int a = 0; a < 6; a++) {
            Humans human = new Humans("name" + a, "surname"+a, "middleName" + a, 18 + a);
            try {
                bus.NewPassenger(human);
            }
            catch (Exception e) {
                String error;
            }
        }
        for (int a = 6; a < 12; a++) {
            Policemen policeman = new Policemen("name" + a, "surname"+a, "middleName" + a, 18 + a,
                    "department"+a, "major", 100+a);
            try {
                bus.NewPassenger(policeman);
            }
            catch (Exception e) {
                String error;
            }
        }
        for (int a = 12; a < 18; a++) {
            Firefighters human = new Firefighters("name" + a, "surname"+a, "middleName" + a, 18 + a,
                    "department" + a, "major");
            try {
                bus.NewPassenger(human);
            }
            catch (Exception e) {
                String error;
            }
        }
        assertEquals(18, bus.getSeatingOccupied());
    }

    @Test
    void AddToFullBuss() {
        Buses bus = new Buses("MAN", "AB4674DB", 10, "Siti", 40);
        boolean vehicleFullException = false;
        for (int a = 0; a < 20; a++) {
            Humans human = new Humans("name"+a, "surname"+a, "middleName" +a, 18+a);
            try {
                bus.NewPassenger(human);
            }
            catch (Exception e)
            {
                if (e instanceof VehicleFull)
                    vehicleFullException = true;
                break;
            }
        }
        assertTrue(vehicleFullException);
    }

    @Test
    void AddingExistingPassenger() {
        Buses bus = new Buses("MAN", "AB4674DB", 10, "Siti", 40);
        Humans human = new Humans("name", "surname", "middleName", 18);
        boolean humanExist = false;
        try {
            bus.NewPassenger(human);
            bus.NewPassenger(human);
        } catch (Exception e) {
            if (e instanceof HumanExisting)
                humanExist = true;
        }
        assertTrue(humanExist);
    }

    @Test
    void FirefighterInPoliceCar() {
        PoliceCars policeCar = new PoliceCars("Ford", "1234", 2,
                60, "Department", "patrol");
        try {
            Policemen policeman = new Policemen("name", "surname", "middleName", 40,
                    "Department", "major", 15484);
            policeCar.NewPassenger(policeman);
            Firefighters firefighter = new Firefighters("name", "surname", "middleName", 31,
                    "Department", "major");
            policeCar.NewPassenger(firefighter);
        }
        catch (Exception e) {
            String error;
        }
        assertEquals(1, policeCar.getSeatingOccupied());
    }
}