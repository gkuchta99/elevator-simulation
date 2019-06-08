public class Person {
    protected int mass;
    protected int destinationFloor;
    protected int patienceLevel;

    public Person(int mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
    }

    public Person() {
    }

    public int getMass() {
        return mass;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getPatienceLevel() {
        return patienceLevel;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setPatienceLevel(int patienceLevel) {
        this.patienceLevel = patienceLevel;
    }

    public boolean spaceInElevator(Elevator elevator) {
        if (elevator.pplInElevator.size() < elevator.getCapacity() && elevator.getActualMass() + mass < elevator.getMassCapacity()) {
            return true;
        }
        return false;
    }

    public void decreasingPatienceLevel() {
        int temp;
        temp = getPatienceLevel();
        temp = temp - 1;
        setPatienceLevel(temp);
    }


}
