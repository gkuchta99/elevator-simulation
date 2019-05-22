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

    public Floor(int floorNum, Random random) {
        this.floorNum = floorNum;
        this.downSignal = false;
        this.upSignal = false;
        for (int i = 0; i < random.nextInt(3); i++) {
            int m = (int) Math.random() * (100 - 40 + 1) + 40;
            int destFloor = (int) Math.random() * (10 - 1 + 1) + 1;
            int patienceLvl = (int) Math.random() * (15 - 5 + 1) + 5;
            Person p = new Person(m, destFloor, patienceLvl);
            pplOnTheFloor.add(p);
        }
    }

    ArrayList<Person> pplOnTheFloor = new ArrayList<Person>();

}
