import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("data.txt");
        } catch (FileNotFoundException e) {
            System.err.println("FILE NOT FOUND");
        }
        Scanner scanner = new Scanner(System.in);
        int floors = scanner.nextInt();
        int iterations = scanner.nextInt();
        Floor[] floorsArray = new Floor[floors];
        for (int i = 0; i < floorsArray.length; i++) {
            Floor floor = new Floor(i);
            floorsArray[i] = floor;
        }
        Elevator[] elevatorArray = new Elevator[3];
        for (int j = 0; j < 3; j++) {
            Elevator elevator = new Elevator(0, 14, 1000);
            elevatorArray[j] = elevator;
        }
        int[] randomPeopleArray = {1, 2, 0, 1, 1, 0, 0, 1, 2, 0, 0, 1, 2, 1, 1, 2, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0};
        int[] directionsArray = new int[3];
        int[] choosingPeopleTypes = {1, 1, 1, 3, 1, 1, 2, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3};
        int bad = 0;//liczba zliczanych zle obsluzonych osob
        //main loop of simulation
        for (int x = 0; x < iterations; x++) {
            printWriter.println("==============================================");
            printWriter.println("TURN:" + x);
            //generating ppl on the floors
            for (int e = 0; e < randomPeopleArray[(int) (Math.random() * (randomPeopleArray.length - 1))]; e++) {
                int a = (int) (Math.random() * (floorsArray.length));
                switch (choosingPeopleTypes[(int) (Math.random() * (choosingPeopleTypes.length - 1))]) {
                    case 1:
                        floorsArray[a].pplOnTheFloor.add(floorsArray[a].personGenerator(floors));
                        break;
                    case 2:
                        floorsArray[0].pplOnTheFloor.add(floorsArray[a].courierGenerator(floors));
                        break;
                    case 3:
                        floorsArray[a].pplOnTheFloor.add(floorsArray[a].kidGenerator(floors));
                        break;
                    default:
                        System.err.println("ERROR-GENERATING-PEOPLE");
                }
            }
            //showing ppl on the floors
            for (int i = 0; i < floorsArray.length; i++) {
                printWriter.println("Floor:" + i);
                for (int j = 0; j < floorsArray[i].pplOnTheFloor.size(); j++) {
                    printWriter.println(floorsArray[i].pplOnTheFloor.get(j).getName() + ",patience: " + floorsArray[i].pplOnTheFloor.get(j).getPatienceLevel() + ",destination floor: " + floorsArray[i].pplOnTheFloor.get(j).getDestinationFloor());
                }
            }
            //showing ppl in the elevators
            for (int i = 0; i < elevatorArray.length; i++) {
                printWriter.println("Elevator:" + i + ", people in elevator:" + elevatorArray[i].pplInElevator.size());
            }
            //pressing buttons on the floors
            for (int g = 0; g < floorsArray.length; g++) {
                for (int i = 0; i < 3; i++) {
                    if (floorsArray[g].getFloorNum() == elevatorArray[i].getFloorNum()) {
                        floorsArray[g].setSignal(false);
                    } else if (!floorsArray[g].pplOnTheFloor.isEmpty()) {
                        floorsArray[g].setSignal(true);
                    }
                }
            }
            printWriter.println("===================Actions====================");
            for (int z = 0; z < 3; z++) {
                directionsArray[z] = elevatorArray[z].getDirection();
            }
            //moving elevator
            for (int g = 0; g < 3; g++) {
                printWriter.printf("Elevator nr: %d moved from: %d floor", g, elevatorArray[g].getFloorNum());
                elevatorArray[g].movingElevator(floorsArray, directionsArray, g);
                printWriter.printf(" to %d floor\n", elevatorArray[g].getFloorNum());
                for (int z = 0; z < 3; z++) {
                    directionsArray[z] = elevatorArray[z].getDirection();
                }
            }
            //exiting ppl from elevator (works)
            for (int i = 0; i < elevatorArray.length; i++) {
                elevatorArray[i].exit(floorsArray, printWriter);
            }
            // ppl getting into elevator
            for (int i = 0; i < 3; i++) {
                floorsArray[elevatorArray[i].getFloorNum()].getPplIntoElevator(elevatorArray[i], printWriter);
            }
            //decreasing patience level
            for (int f = 0; f < floorsArray.length; f++) {
                for (int g = floorsArray[f].pplOnTheFloor.size() - 1; g >= 0; g--) {
                    floorsArray[f].pplOnTheFloor.get(g).decreasingPatienceLevel();
                    if (floorsArray[f].pplOnTheFloor.get(g).getPatienceLevel() == 0) {
                        printWriter.println(floorsArray[f].pplOnTheFloor.get(g).getName() + " decided to go by stairs at:" + f + " floor");
                        floorsArray[f].pplOnTheFloor.remove(g);
                        bad++;
                    }
                }
            }
        }
        printWriter.println("Well serviced:" + elevatorArray[0].getGood() + elevatorArray[1].getGood() + elevatorArray[2].getGood() + " poorly serviced:" + bad);
        printWriter.close();
    }
}
