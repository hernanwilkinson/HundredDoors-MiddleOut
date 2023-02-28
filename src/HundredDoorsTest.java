import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

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
        var exception = assertThrows(
                RuntimeException.class,
                ()->new DoorsFlipper(0));
        assertEquals(DoorsFlipper.INVALID_NUMBER_OF_DOORS,exception.getMessage());
    }

    @Test
    public void flipStepMustBeStrictlyPositive() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                RuntimeException.class,
                ()->doorsFlipper.flipEvery(0));
        assertEquals(DoorsFlipper.INVALID_FLIP_STEP,exception.getMessage());
        assertTrue(doorsFlipper.isClosed(0));
    }

    @Test
    public void flipStepMustLessOrEqualToDoorsSize() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                RuntimeException.class,
                ()->doorsFlipper.flipEvery(2));
        assertEquals(DoorsFlipper.INVALID_FLIP_STEP,exception.getMessage());
        assertTrue(doorsFlipper.isClosed(0));
    }

    @Test
    public void doorPositionMustBePositive() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                RuntimeException.class,
                ()->doorsFlipper.isClosed(-1));
        assertEquals(DoorsFlipper.INVALID_DOOR_POSITION,exception.getMessage());
        assertTrue(doorsFlipper.isClosed(0));
    }
}