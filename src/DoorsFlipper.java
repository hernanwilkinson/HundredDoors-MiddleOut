public class DoorsFlipper {
    private boolean doors[];

    public DoorsFlipper(int numberOfDoors) {
        doors = new boolean[numberOfDoors];
        for (int doorPosition = 0; doorPosition < doors.length; doorPosition++)
            doors[doorPosition] = false;
    }

    public boolean isClosed(int i) {
        return !doors[i];
    }

    public void flipEvery(int i) {
        for (int j = i-1; j < doors.length ; j+=i)
            doors[j] = !doors[j];
    }
}
