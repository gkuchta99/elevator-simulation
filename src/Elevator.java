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

    public Elevator(int floorNum, int direction, int capacity, int massCapacity) {
        this.floorNum = floorNum;
        this.direction = direction;
        this.capacity = capacity;
        this.massCapacity = massCapacity;
        this.actualMass = 0;
    }

    public Elevator() {
    }

    public int getSignal() {
        // metoda bedzie zwracala wartosc na jakim pietrze jest wzywana winda metoda jak na razie zwraca 1
        return 1;
    }

    ArrayList<Person> pplInElevator = new ArrayList<Person>(capacity);
}
