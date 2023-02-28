public class DoorsFlipper {
    private boolean doors[];

    public DoorsFlipper(int i) {
        doors = new boolean[i];
        for (int j = 0; j < doors.length; j++)
            doors[j] = false;
    }

    public boolean isClosed(int i) {
        return !doors[i];
    }

    public void flipEvery(int i) {
        for (int j = i-1; j < doors.length ; j+=i)
            doors[j] = !doors[j];
    }
}
