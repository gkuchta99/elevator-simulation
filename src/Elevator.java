import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int floorNum;
    private int capacity;
    private int direction;
    private int massCapacity; // in kilograms
    private int actualMass;
    private boolean destinationAcomplished;
    ArrayList<Person> pplInElevator = new ArrayList<>(capacity);

    public int getDirection() {
        return direction;
    }

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

    public Elevator(int floorNum, int capacity, int massCapacity) {
        this.floorNum = floorNum;
        this.capacity = capacity;
        this.massCapacity = massCapacity;
        this.actualMass = 0;
    }

    public void movingElevator(Floor[] floorArray, int[] directionsArray, int elevatorNum) {
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
                if ((Math.abs(floorNum - floorArray[i].getFloorNum()) < temp) && (floorArray[i].getSignal()) && (floorArray[i].getFloorNum() != directionsArray[(elevatorNum + 1) % 3]) && (floorArray[i].getFloorNum() != directionsArray[(elevatorNum + 2) % 3])) {
                    direction = floorArray[i].getFloorNum();
                    temp = Math.abs(floorNum - direction);

                }
                if (temp == 10) {
                    direction = floorNum;
                }
            }
        }
        if (direction < floorNum) {
            floorNum--;
        } else if (direction > floorNum) {
            floorNum++;
        }
    }

    public void exit(Floor floorArray[], PrintWriter printWriter) {
        for (int i = pplInElevator.size() - 1; i >= 0; i--) {
            if (pplInElevator.get(i).getDestinationFloor() == floorNum) {
                if (pplInElevator.get(i) instanceof Courier) {
                    for (int j = 0; j < ((Courier) pplInElevator.get(i)).packList.size(); j++) {
                        if (((Courier) pplInElevator.get(i)).packList.get(0).getDestinationFloor() == floorNum) {
                            pplInElevator.get(i).setMass(pplInElevator.get(i).getMass() - ((Courier) pplInElevator.get(i)).packList.get(0).getMass());
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
                printWriter.println(pplInElevator.get(i).getName() + " exited elevator at:" + floorNum + " floor");
                pplInElevator.remove(i);
            }
        }
    }
}
