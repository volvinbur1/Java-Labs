import humans.Humans;
import org.junit.jupiter.api.Test;
import vehicle.Buses;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void PeoplesInBuss() {
        Buses bus = new Buses("MAN", "AB4674DB", 18, "Siti", 40);
        for (int a = 0; a < 6; a++) {
            Humans human = new Humans();
            bus.NewPassenger();
        }
    }
}