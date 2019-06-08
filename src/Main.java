import javax.imageio.IIOException;
import java.io.*;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/*Sajkowski-Kuchta*/
public class Main {
    public static void main(String[] args) {
       /* PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("data.txt");
        } catch (FileNotFoundException e) {
            System.err.println("FILE NOT FOUND");
        }*/
        Floor[] floorsArray = new Floor[10]; // temporary solution
        for (int i = 0; i < 10; i++) {
            Floor floor = new Floor(i);
            floorsArray[i] = floor;
        }
        Elevator elevator = new Elevator(0, 14, 1000);
        int[] randomPeopleArray = {1, 2, 0, 1, 1, 0, 0, 1, 2, 0, 0, 1, 2, 1, 1, 2, 0, 1, 1, 1, 1, 2, 2, 1, 0, 0};
        int[] choosingPeopleTypes = {1, 1, 1, 2, 3, 1, 1, 2, 3, 2, 2, 1, 1, 1, 1, 2};

        //main loop of simulation
        for (int x = 0; x < 100; x++) {
            System.err.println("----------------------------------------------");
            //exiting ppl from elevator (works)
            if (!elevator.pplInElevator.isEmpty()) {
                for (int a = elevator.pplInElevator.size() - 1; a >= 0; a--) {
                    if(elevator.pplInElevator.get(a).getDestinationFloor()==elevator.getFloorNum()){
                        if(elevator.pplInElevator.get(a) instanceof Courier){
                            floorsArray[elevator.getFloorNum()].pplOnTheFloor.add(elevator.pplInElevator.get(a));

                        }
                        else{

                        }
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
            System.out.println("winda docelowo jedzie na " + elevator.direction + " pietro");
            System.out.println("winda jest na " + elevator.getFloorNum() + " pietrze");
            elevator.movingElevator(floorsArray);
            System.out.println("winda jest na " + elevator.getFloorNum() + " pietrze");
            // ppl getting into elevator (works) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
            for (int e = 0; e < randomPeopleArray[(int) (Math.random() * (randomPeopleArray.length - 1))]; e++) {
                int a = (int) (Math.random() * 9);
                switch (choosingPeopleTypes[(int) (Math.random() * (choosingPeopleTypes.length - 1))]) {
                    case 1:
                        floorsArray[a].pplOnTheFloor.add(floorsArray[a].personGenerator());
                        System.out.println("wygenerowano zwykla osobe na " + a + " pietrze");
                        break;
                    case 2:
                        floorsArray[a].pplOnTheFloor.add(floorsArray[a].courierGenerator());
                        System.out.println("wygenerowano kuriera na " + a + " pietrze");
                        break;
                    case 3:
                        floorsArray[a].pplOnTheFloor.add(floorsArray[a].disabledGenerator());
                        System.out.println("wygenerowano niepelnosprawnego na " + a + " pietrze");
                        break;
                    default:
                        System.err.println("Blad przy generowaniu typow ludzi");
                }
            }
            System.err.println("----------------------------------------------");
        }
        //printWriter.close();
    }
}
