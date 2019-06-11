public class Kid extends Person {
    @Override
    public String getName() {
        return "Kid";
    }

    @Override
    public boolean spaceInElevator(Elevator elevator) {
        if (elevator.pplInElevator.size() < elevator.getCapacity()
                && elevator.pplInElevator.size() != 0
                && elevator.getActualMass() + mass < elevator.getMassCapacity())
            return true;
        return false;
    }

    public Kid(int mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
    }
}

