import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to elevator simulation!");
        Scanner scanner = new Scanner(System.in);
        int mainIterations;
        mainIterations = scanner.nextInt();
        int[] randomizePpl = new int[]{0, 1, 2, 0, 0, 1, 2, 1, 0, 0}; // array for generating nums of amount of ppl to generate in 1 iteration of main loop
        Floor[] floorsArray = new Floor[10]; // temporary solution
        for (int z = 1; z <= 10; z++) {
            Floor floor = new Floor(z);
            floorsArray[z - 1] = floor;
        }
        Elevator elevator = new Elevator(1, 14, 1000);
        List<Integer> wherePplAt = new ArrayList<Integer>();
        // main loop of our program
        for (int i = 0; i < mainIterations; i++) {
            // ppl exiting elevator
            // ppl geting in the elevator (temporary solution)
            if (floorsArray[elevator.getFloorNum() - 1].pplOnTheFloor.size() != 0) {
                floorsArray[elevator.getFloorNum() - 1].getPplIntoElevator(elevator);
            }
            for (int j = 0; j < randomizePpl[(int) Math.random() * 9]; j++) { // loop that generates ppl on the floor
                int temp = (int) Math.random() * 9 + 1;
                floorsArray[temp].pplOnTheFloor.add(floorsArray[temp].personGenerator(floorsArray[temp]));
            }
            i = 0;
            for (; i < 10; i++) { // loop that will check where people are at
                if (floorsArray[i + 1].pplOnTheFloor.size() != 0)
                    wherePplAt.add(i + 1);
            }
            i = 0;
            // pressing buttons on the floors (up signal and down signal)
            for (; i < wherePplAt.size(); i++) {
                for (int j = 0; j < floorsArray[wherePplAt.get(i)].pplOnTheFloor.size(); i++) {
                    if (floorsArray[wherePplAt.get(i)].pplOnTheFloor.get(j).getDestinationFloor() > floorsArray[wherePplAt.get(i)].getFloorNum()) {
                        floorsArray[wherePplAt.get(i)].setUpSignal(true);
                    } else
                        floorsArray[wherePplAt.get(i)].setDownSignal(true);
                }
            }
            // moving elevator
            if (elevator.getFloorNum() - elevator.getSignal(floorsArray) < 0) {
                int temp = elevator.getFloorNum();
                temp++;
                elevator.setFloorNum(temp);
            } else if (elevator.getFloorNum() - elevator.getSignal(floorsArray) > 0) {
                int temp = elevator.getFloorNum();
                temp--;
                elevator.setFloorNum(temp);
            }
            i = 0;
            // ppl geting in the elevator (temporary solution)
            if (floorsArray[elevator.getFloorNum() - 1].pplOnTheFloor.size() != 0) {
                floorsArray[elevator.getFloorNum() - 1].getPplIntoElevator(elevator);
            }
            i = 0;


        }
    }
}