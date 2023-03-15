public class DoorsFlipper {
    public static final String INVALID_NUMBER_OF_DOORS = "Number of doors must be strictly positive";
    public static final String INVALID_FLIP_STEP = "Flip steep must be between 1 and numbers of doors";
    public static final String INVALID_DOOR_POSITION = "Door position must be between 0 and number of door - 1";

    private boolean doors[];

    public DoorsFlipper(int numberOfDoors) {
        assertValidNumberOfDoors(numberOfDoors);

        doors = new boolean[numberOfDoors];
        closeAllDoors();
    }

    private void assertValidNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 1) throw new IllegalArgumentException(INVALID_NUMBER_OF_DOORS);
    }

    private void closeAllDoors() {
        for (int doorIndex = 0; doorIndex < doors.length; doorIndex++)
            doors[doorIndex] = false;
    }

    public boolean isClosed(int doorPosition) {
        assertValidDoorPosition(doorPosition);

        return !doors[doorPosition-1];
    }

    private void assertValidDoorPosition(int doorPosition) {
        if(doorPosition < 1 || doorPosition > doors.length) throw new IllegalArgumentException(INVALID_DOOR_POSITION);
    }

    public void flipEvery(int step) {
        assertValidStep(step);

        for (int doorIndex = step-1; doorIndex < doors.length ; doorIndex+=step)
            flipAt(doorIndex);
    }

    private void flipAt(int doorIndex) {
        doors[doorIndex] = !doors[doorIndex];
    }

    private void assertValidStep(int step) {
        if (step < 1 || step > doors.length) throw new IllegalArgumentException(INVALID_FLIP_STEP);
    }

    public void flipAll() {
        for (int step = 1; step <= doors.length; step++)
            flipEvery(step);
    }
}
