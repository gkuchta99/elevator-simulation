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
        Elevator[] elevatorArray = new Elevator[3];
        for(int j = 0;j<3;j++) {
            Elevator elevator = new Elevator(0, 14, 1000);
            elevatorArray[j]=elevator;

        }
        int[] randomPeopleArray = {1, 2, 0, 1, 1, 0, 0, 1, 2, 0, 0, 1, 2, 1, 1, 2, 0, 1, 1, 1, 1, 2, 2, 1, 0, 0};
        int[] choosingPeopleTypes = {1, 1, 1, 2, 3, 1, 1, 2, 3, 2, 2, 1, 1, 1, 1, 2};
        //main loop of simulation
        for (int x = 0; x < 100; x++) {
            System.err.println("----------------------------------------------");
            //exiting ppl from elevator (works)
            elevator.exit(floorsArray);
            //pressing buttons on the floors (works)
            for (int g = 0; g < 10; g++) {
                if(floorsArray[g].getFloorNum()==elevator.getFloorNum()){
                    floorsArray[g].setSignal(false);
                }
                if (!floorsArray[g].pplOnTheFloor.isEmpty()) {
                    floorsArray[g].setSignal(true);
                }
            }
            System.out.println("winda docelowo jedzie na " + elevator.direction + " pietro");
            System.out.println("winda jest na " + elevator.getFloorNum() + " pietrze");
            elevator.movingElevator(floorsArray);
            System.out.println("winda jest na " + elevator.getFloorNum() + " pietrze");
            // ppl getting into elevator (works) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            floorsArray[elevator.getFloorNum()].getPplIntoElevator(elevator);
            System.out.println("w windzie jest "+ elevator.pplInElevator.size()+" osob");

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
                        floorsArray[a].pplOnTheFloor.add(floorsArray[a].kidGenerator());
                        System.out.println("wygenerowano dziecko na " + a + " pietrze");
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
