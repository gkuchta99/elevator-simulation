import java.util.ArrayList;

public class Elevator {
    private int floorNum;
    private int capacity; // capacity in person
    private int direction; // for 1 up for -1 down for 0 nothing
    private int massCapacity; // in kilograms
    private int actualMass;
    private boolean upDirection;

    public int getActualMass() {
        return actualMass;
    }

    public boolean getUpDirection() {
        return upDirection;
    }

    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
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
        this.upDirection = true;
    }

    // method getSignal returns the closest floor (temporary solution)
    /*public int getSignal(Floor[] floorsArray) {
        // idk if needed
    }*/
    //its temporary solution !!!!
    public void movingElevator() {
        int temp = getFloorNum();
        if (floorNum == 0) {
            setUpDirection(true);
        }
        else if(floorNum==9) {
            setUpDirection(false);
        }
        if (floorNum != 9 && upDirection) {
            ++temp;
            setFloorNum(temp);
        } else if (floorNum != 0 && !upDirection) {
            --temp;
            setFloorNum(temp);
        }
    }

    ArrayList<Person> pplInElevator = new ArrayList<Person>(capacity);
}