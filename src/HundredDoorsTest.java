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

    @Test
    public void doorPositionMustLessThanNumberOfDoors() {
        var doorsFlipper = new DoorsFlipper(1);

        var exception = assertThrows(
                RuntimeException.class,
                ()->doorsFlipper.isClosed(1));
        assertEquals(DoorsFlipper.INVALID_DOOR_POSITION,exception.getMessage());
        assertTrue(doorsFlipper.isClosed(0));
    }

    @Test
    public void canFlipAllDoorsByStep() {
        var doorsFlipper = new DoorsFlipper(4);
        doorsFlipper.flipAll();

        assertFalse(doorsFlipper.isClosed(0));
        assertTrue(doorsFlipper.isClosed(1));
        assertTrue(doorsFlipper.isClosed(2));
        assertFalse(doorsFlipper.isClosed(3));
    }

    @Test
    public void flipsCorrectlyForHundredDoors() {
        var doorsFlipper = new DoorsFlipper(100);
        doorsFlipper.flipAll();

        final List<Integer> opened = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        for (int doorPosition = 0; doorPosition < 100; doorPosition++)
            assertEquals(!opened.contains(doorPosition+1),doorsFlipper.isClosed(doorPosition));
    }
}