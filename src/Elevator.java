import java.util.ArrayList;

public class Elevator {
    private int floorNum;
    private int capacity; // capacity in person
    private int direction; // for 1 up for -1 down for 0 nothing
    private int massCapacity; // in kilograms
    private int actualMass;

    public int getActualMass() {
        return actualMass;
    }

    public void setActualMass(int actualMass) {
        this.actualMass = actualMass;
    }

    public int getMassCapacity() {
        return massCapacity;
    }

    public void setMassCapacity(int massCapacity) {
        this.massCapacity = massCapacity;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDirection() {
        return direction;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public Elevator(int floorNum, int capacity, int massCapacity) {
        this.floorNum = floorNum;
        this.capacity = capacity;
        this.massCapacity = massCapacity;
        this.actualMass = 0;
    }

    public Elevator() {
    }

    // method getSignal returns the closest floor (temporary solution)
    public int getSignal(Floor[] floorsArray){
        int destinationFloor = floorNum;
        for (int i = 0; i < 9; i++) {
            if (floorsArray[i].pplOnTheFloor.size()!=0 &&(Math.abs(floorNum - floorsArray[i].getFloorNum()) > Math.abs(floorNum - destinationFloor)))
                destinationFloor = floorsArray[i].getFloorNum();
        }
        return destinationFloor;
    }

    ArrayList<Person> pplInElevator = new ArrayList<Person>(capacity);
}
