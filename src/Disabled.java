public class Disabled extends Person {
    @Override
    public boolean spaceInElevator(Elevator elevator) {
        if (elevator.pplInElevator.size() < elevator.getCapacity()
                && elevator.pplInElevator.size() != 0
                && elevator.getActualMass() + mass < elevator.getMassCapacity()) // jak na razie dalem warunek sprawdzajacy czy jest ktokolwiek w windzie ale trzeba zmienic na to czy jest osoba sprawna w windzie
            return true;
        return false;
    }

    public Disabled(int mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
    }
}
