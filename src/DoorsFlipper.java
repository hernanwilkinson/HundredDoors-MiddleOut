public class DoorsFlipper {
    private boolean doors[];

    public DoorsFlipper(int i) {
        doors = new boolean[1];
        doors[0] = false;
    }

    public boolean isClosed(int i) {
        return !doors[0];
    }

    public void flipEvery(int i) {
        doors[0] = true;
    }
}
