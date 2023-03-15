public class DoorsFlipper {
    public static final String INVALID_NUMBER_OF_DOORS = "Number of doors must be strictly positive";
    public static final String INVALID_FLIP_STEP = "Flip steep must be between 1 and numbers of doors";
    public static final String INVALID_DOOR_POSITION = "Door position must be between 0 and number of door - 1";

    private boolean[] opened;

    public DoorsFlipper(int numberOfDoors) {
        assertValidNumberOfDoors(numberOfDoors);

        opened = new boolean[numberOfDoors];
    }

    private void assertValidNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 1) throw new IllegalArgumentException(INVALID_NUMBER_OF_DOORS);
    }

    public boolean isClosed(int doorPosition) {
        assertValidDoorPosition(doorPosition);

        return !opened[doorPosition-1];
    }

    private void assertValidDoorPosition(int doorPosition) {
        if(doorPosition < 1 || doorPosition > opened.length) throw new IllegalArgumentException(INVALID_DOOR_POSITION);
    }

    public void flipEvery(int step) {
        assertValidStep(step);

        for (int doorIndex = step-1; doorIndex < opened.length ; doorIndex+=step)
            flipAt(doorIndex);
    }

    private void flipAt(int doorIndex) {
        opened[doorIndex] = !opened[doorIndex];
    }

    private void assertValidStep(int step) {
        if (step < 1 || step > opened.length) throw new IllegalArgumentException(INVALID_FLIP_STEP);
    }

    public void flipAll() {
        for (int step = 1; step <= opened.length; step++)
            flipEvery(step);
    }
}
