import java.util.ArrayList;
import java.util.Random;

public class Floor {
    private boolean upSignal;
    private boolean downSignal;
    private int floorNum;
    ArrayList<Person> arrayList;

    public int getFloorNum() {
        return floorNum;
    }

    public boolean getUpSignal() {
        return upSignal;
    }

    public boolean getDownSignal() {
        return downSignal;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public void setDownSignal(boolean downSignal) {
        this.downSignal = downSignal;
    }

    public void setUpSignal(boolean upSignal) {
        this.upSignal = upSignal;
    }

    public boolean pressedButton() {
        // metoda zwraca czy jaki kolwiek sygnal jest wcisniety
        if (this.upSignal || this.downSignal) {
            return true;
        }
        return false;
    }

    public Floor(int floorNum) {
        this.floorNum = floorNum;
        this.downSignal = false;
        this.upSignal = false;
    }

    ArrayList<Person> pplOnTheFloor = new ArrayList<Person>();

    public Person personGenerator(Floor floor) {
        int mass = 40 + (int) (Math.random() * ((100 - 40) + 1));
        int destinationLevel = 1 + (int) (Math.random() * ((10 - 1) + 1));
        int patienceLevel = 5 + (int) (Math.random() * ((15 - 5) + 1));
        Person person = new Person(mass,destinationLevel,patienceLevel);
        return person;
    }
    public Disabled disabledGenerator(Floor floor){
        int mass = 40 + (int) (Math.random() * ((80 - 40) + 1));
        int destinationLevel = 1 + (int) (Math.random() * ((10 - 1) + 1));
        int patienceLevel = 100 + (int) (Math.random() * ((15 - 5) + 1));
        Disabled disabled = new Disabled(mass,destinationLevel,patienceLevel);
        return disabled;
    }
    public Courier courierGenerator(Floor floor){
        int mass = 40 + (int) (Math.random() * ((100 - 40) + 1));
        int destinationLevel = 1 + (int) (Math.random() * ((10 - 1) + 1));
        int patienceLevel = 100 + (int) (Math.random() * ((15 - 5) + 1));
        Courier courier = new Courier(mass,destinationLevel,patienceLevel);
        return courier;
    }
}
