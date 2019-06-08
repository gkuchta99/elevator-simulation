import java.util.ArrayList;
import java.util.Collections;

public class Courier extends Person {
    ArrayList<Pack> packList = new ArrayList<>();

    public Courier(int mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
        for(int i=0;i<(int)(Math.random()*2 +1);i++) {
            Pack pack = new Pack((int)(Math.random() * (8) + 1), (int) (Math.random() * 8 + 1));
            packList.add(pack);
        }
        Collections.sort(packList);
    }
}
