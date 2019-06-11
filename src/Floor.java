import java.io.PrintWriter;
import java.util.ArrayList;

public class Floor {
    private boolean signal;
    private int floorNum;
    ArrayList<Person> pplOnTheFloor = new ArrayList<>();

    public int getFloorNum() {
        return floorNum;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public boolean getSignal() {
        return signal;
    }

    public Floor(int floorNum) {
        this.floorNum = floorNum;
        this.signal = false;
    }

    public Person personGenerator(int floors) {
        int temp;
        int mass = 40 + (int) (Math.random() * ((100 - 40) + 1));
        do {
            temp = (int) (Math.random() * (floors - 1));
        } while (temp == floorNum);
        int patienceLevel = 5 + (int) (Math.random() * ((15 - 5) + 1));
        Person person = new Person(mass, temp, patienceLevel);
        return person;
    }

    public Kid kidGenerator(int floors) {
        int temp;
        int mass = 15 + (int) (Math.random() * 35);
        do {
            temp = (int) (Math.random() * (floors - 1));
        } while (temp == floorNum);
        int patienceLevel = 5 + (int) (Math.random() * ((15 - 5) + 1));
        Kid kid = new Kid(mass, temp, patienceLevel);
        return kid;
    }

    public Courier courierGenerator(int floors) {
        int mass = 40 + (int) (Math.random() * ((100 - 40) + 1));
        Courier courier = new Courier(mass, 100,floors);
        return courier;
    }

    public void getPplIntoElevator(Elevator elevator, PrintWriter printWriter) {
        if (pplOnTheFloor.size() != 0) {
            for (int i = pplOnTheFloor.size() - 1; i >= 0; i--) {
                if (pplOnTheFloor.get(i).spaceInElevator(elevator)) {
                    elevator.pplInElevator.add(pplOnTheFloor.get(i));
                    elevator.setActualMass(elevator.getActualMass() + pplOnTheFloor.get(i).getMass());
                    printWriter.println(pplOnTheFloor.get(i).getName() + " entered elevator at:" + floorNum + " floor");
                    pplOnTheFloor.remove(i);
                }
            }
        }
    }
}
