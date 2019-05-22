public class Courier extends Person {
    private boolean pack;

    public boolean getPack() {
        return this.pack;
    }

    public void setPack(boolean pack) {
        this.pack = pack;
    }

    public Courier(int mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
        this.pack = true;
    }
}
