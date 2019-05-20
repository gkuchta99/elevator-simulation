public class Disabled extends Person {
    @Override
    public boolean spaceInElevator() {
        // nadpisanie metody z klasy person
        return true;
    }

    public Disabled(double mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
    }

    public Disabled() {
    }
}
