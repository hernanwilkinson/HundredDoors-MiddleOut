public class DoorsFlipper {
    public static final String INVALID_NUMBER_OF_DOORS = "Number of doors must be strictly positive";
    public static final String INVALID_FLIP_STEP = "Flip steep must be strictly positive";

    private boolean doors[];

    public DoorsFlipper(int numberOfDoors) {
        assertValidNumberOfDoors(numberOfDoors);

        doors = new boolean[numberOfDoors];
        closeAllDoors();
    }

    private void assertValidNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 1) throw new RuntimeException(INVALID_NUMBER_OF_DOORS);
    }

    private void closeAllDoors() {
        for (int doorPosition = 0; doorPosition < doors.length; doorPosition++)
            doors[doorPosition] = false;
    }

    public boolean isClosed(int doorPosition) {
        return !doors[doorPosition];
    }

    public void flipEvery(int step) {
        for (int doorPosition = step-1; doorPosition < doors.length ; doorPosition+=step)
            doors[doorPosition] = !doors[doorPosition];
    }
}
