import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HundredDoorsTest {
    @Test
    public void doorsStartClosed() {
        var doorsFlipper = new DoorsFlipper(1);

        assertTrue(doorsFlipper.isClosed(0));
    }

    @Test
    public void doorEndsOpenWhenFlippingFromClosed() {
        var doorsFlipper = new DoorsFlipper(1);
        doorsFlipper.flipEvery(1);

        assertFalse(doorsFlipper.isClosed(0));
    }
}