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

    public void flipEvery(int i) {
        for (int j = i-1; j < doors.length ; j+=i)
            doors[j] = !doors[j];
    }
}
