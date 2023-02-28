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

    @Test
    public void doorEndsClosedWhenFlippingFromOpened() {
        var doorsFlipper = new DoorsFlipper(1);
        doorsFlipper.flipEvery(1);
        doorsFlipper.flipEvery(1);

        assertTrue(doorsFlipper.isClosed(0));
    }

    @Test
    public void canFlipMoreThanOneDoorByAStep() {
        var doorsFlipper = new DoorsFlipper(4);
        doorsFlipper.flipEvery(2);

        assertTrue(doorsFlipper.isClosed(0));
        assertFalse(doorsFlipper.isClosed(1));
        assertTrue(doorsFlipper.isClosed(2));
        assertFalse(doorsFlipper.isClosed(3));
    }

    @Test
    public void numberOfDoorsMustBeStrictlyPositive() {
        assertThrows(
                RuntimeException.class,
                ()->new DoorsFlipper(0),
                DoorsFlipper.INVALID_NUMBER_OF_DOORS);
    }
}