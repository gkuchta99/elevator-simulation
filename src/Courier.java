import java.util.ArrayList;
import java.util.Collections;

public class Courier extends Person {
    ArrayList<Pack> packList = new ArrayList<>();

    public Courier(int mass,int patienceLevel) {
        this.patienceLevel = patienceLevel;
        for(int i=0;i<(int)(Math.random()*2 +1);i++) {
            Pack pack = new Pack((int)(Math.random() * (8) + 1), (int) (Math.random() * 8 + 1));
            packList.add(pack);
            mass+=pack.getMass();
        }
        this.mass=mass;
        Collections.sort(packList);
        this.destinationFloor = packList.get(0).getDestinationFloor();
    }
}
