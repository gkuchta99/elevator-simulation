import javax.imageio.IIOException;
import java.io.*;
import java.nio.channels.FileLock;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("data.txt");
        } catch (FileNotFoundException e) {
            System.err.println("FILE NOT FOUND");
        }
        Floor[] floorsArray = new Floor[10]; // temporary solution
        for (int i = 0; i < 10; i++) {
            Floor floor = new Floor(i);
            floorsArray[i] = floor;
        }
        Elevator elevator = new Elevator(0, 14, 1000);
        /*for (int j = 0; j < 10; j++) { generatin some ppl in elevator
            elevator.pplInElevator.add(floorsArray[0].personGenerator());
        }*/

        // generating some ppl on the floor
       /* for (int f = 0; f < 10; f++) {
            floorsArray[f].pplOnTheFloor.add(floorsArray[f].personGenerator());
        }*/

        //main loop of simulation
        for (int x = 0; x < 100; x++) {
            //exiting ppl from elevator (works)
            if (!elevator.pplInElevator.isEmpty()) {
                for (int a = elevator.pplInElevator.size() - 1; a >= 0; a--) {
                    if (elevator.pplInElevator.get(a).getDestinationFloor() == elevator.getFloorNum()) {
                        elevator.setActualMass(elevator.getActualMass() - elevator.pplInElevator.get(a).getMass());
                        elevator.pplInElevator.remove(a);
                        printWriter.println("Person exited elevator at:"+elevator.getFloorNum()+" floor");
                    }
                }
            }
            //pressing buttons on the floors (works)
            for (int b = 0; b < 10; b++) {
                if (!floorsArray[b].pplOnTheFloor.isEmpty()) {
                    for (int c = 0; c < floorsArray[b].pplOnTheFloor.size(); c++) {
                        if (floorsArray[b].pplOnTheFloor.get(c).getDestinationFloor() - b > 0 && floorsArray[b].getUpSignal() == false) {
                            floorsArray[b].setUpSignal(true);
                        } else if (floorsArray[b].pplOnTheFloor.get(c).getDestinationFloor() - b < 0 && floorsArray[b].getDownSignal() == false) {
                            floorsArray[b].setDownSignal(true);
                        }
                    }
                }
            }
            //its temporary solution (works)
            elevator.movingElevator(floorsArray);
            // ppl getting into elevator (works)
            floorsArray[elevator.getFloorNum()].getPplIntoElevator(elevator);
            //decreasing patience level
            for (int f = 0; f < 10; f++) {
                for (int g = floorsArray[f].pplOnTheFloor.size() - 1; g >= 0; g--) {
                    floorsArray[f].pplOnTheFloor.get(g).decreasingPatienceLevel();
                    if (floorsArray[f].pplOnTheFloor.get(g).getPatienceLevel() == 0) {
                        floorsArray[f].pplOnTheFloor.remove(g);
                        System.out.println("zrezygnowal");
                    }
                }
            }
            //generating ppl on the floors
            for (int e = 0; e < 2; e++) {
                floorsArray[(int) Math.random() * 9].pplOnTheFloor.add(floorsArray[0].personGenerator());
            }
        }
        printWriter.close();
    }
}
