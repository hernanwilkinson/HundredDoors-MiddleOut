public class DoorsFlipper {
    private boolean doors[];

    public DoorsFlipper(int numberOfDoors) {
        doors = new boolean[numberOfDoors];
        closeAllDoors();
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
