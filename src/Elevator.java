import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int floorNum;
    private int capacity; // capacity in person
    public int direction; // public bo bedzie modyfikowany
    private int massCapacity; // in kilograms
    private int actualMass;
    private boolean upDirection;
    public boolean destinationAcomplished; // public bo bedzie modyfikowany
    ArrayList<Person> pplInElevator = new ArrayList<>(capacity);

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
    public void movingElevator(Floor[] floorArray) {
       /* int temp = getFloorNum();
        if (floorNum == 0) {
            setUpDirection(true);
        } else if (floorNum == 9) {
            setUpDirection(false);
        }
        if (floorNum != 9 && upDirection) {
            ++temp;
            setFloorNum(temp);
        } else if (floorNum != 0 && !upDirection) {
            --temp;
            setFloorNum(temp);
        }*/
        if (floorNum == direction) {
            destinationAcomplished = true;
        }
        if (pplInElevator.size() != 0) {
            int temp = 0;
            if (destinationAcomplished) {
                for (int i = 0; i < pplInElevator.size(); i++) {
                    if (Math.abs(floorNum - pplInElevator.get(i).getDestinationFloor()) >= temp) {
                        direction = pplInElevator.get(i).getDestinationFloor();
                        temp = Math.abs(floorNum - direction);
                    }
                }
                destinationAcomplished = false;
            }
        }
        if (pplInElevator.size() == 0) {
            int temp = 10;
            for (int i = 0; i < 10; i++) {
                if ((Math.abs(floorNum - floorArray[i].getFloorNum()) < temp) && (floorArray[i].getUpSignal() || floorArray[i].getDownSignal())) {
                    direction = floorArray[i].getFloorNum();
                    temp = Math.abs(floorNum - direction);

                }
                if (temp == 10) {
                    direction = floorNum;
                }
            }
        }
        //ruszamy winda
        if (direction < floorNum) {
            floorNum--;
        } else if (direction > floorNum) {
            floorNum++;
        }
    }

    public void exit(Floor floorArray[]) {
        for (int i = pplInElevator.size() - 1; i >= 0; i--) {
            if (pplInElevator.get(i).getDestinationFloor() == floorNum) {
                if (pplInElevator.get(i) instanceof Courier) {
                    for (int j = 0; j < ((Courier) pplInElevator.get(i)).packList.size(); j++) {
                        if (((Courier) pplInElevator.get(i)).packList.get(0).getDestinationFloor() == floorNum) {
                            ((Courier) pplInElevator.get(i)).packList.remove(0);
                        }
                    }
                    if (((Courier) pplInElevator.get(i)).packList.isEmpty()) {
                        pplInElevator.get(i).setDestinationFloor(0);
                    } else {
                        pplInElevator.get(i).setDestinationFloor(((Courier) pplInElevator.get(i)).packList.get(0).getDestinationFloor());
                    }
                    floorArray[floorNum].pplOnTheFloor.add(pplInElevator.get(i));
                }
                pplInElevator.remove(i);
            }
        }
    }
}
