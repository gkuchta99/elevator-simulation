import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainIterations;
        mainIterations = 100;
        int[] randomizePpl = new int[]{0, 1, 2, 0, 0, 1, 2, 1, 0, 0}; // array for generating nums of amount of ppl to generate in 1 iteration of main loop
        Floor[] floorsArray = new Floor[10]; // temporary solution
        for (int z = 0; z < 10; z++) {
            Floor floor = new Floor(z);
            floorsArray[z] = floor;
        }
        Elevator elevator = new Elevator(0, 14, 1000);
        List<Integer> wherePplAt = new ArrayList<Integer>();
        // main loop of program
        for (int x = 0; x < mainIterations; x++) {
            int i;
            if (elevator.pplInElevator.size() != 0) {
                for (i = elevator.pplInElevator.size() - 1; i <= 0; i--) {
                    if (elevator.pplInElevator.get(i).getDestinationFloor() == elevator.getFloorNum()) {
                        elevator.pplInElevator.remove(i);
                    }
                }
            }
            // ppl geting in the elevator (temporary solution)
            if (floorsArray[elevator.getFloorNum()].pplOnTheFloor.size() != 0) {
                floorsArray[elevator.getFloorNum()].getPplIntoElevator(elevator);
            }
            i = 0;
            // loop that will check where people are at
            for (; i < 10; i++) {
                if (floorsArray[i].pplOnTheFloor.size() != 0)
                    wherePplAt.add(i);
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
            if (floorsArray[elevator.getFloorNum()].pplOnTheFloor.size() != 0) {
                floorsArray[elevator.getFloorNum()].getPplIntoElevator(elevator);
            }
            if (floorsArray[elevator.getFloorNum()].pplOnTheFloor.size() == 0) {
                floorsArray[elevator.getFloorNum()].setUpSignal(false);
                floorsArray[elevator.getFloorNum()].setDownSignal(false);
            }
            // generating ppl
            for (; i < randomizePpl[(int) Math.random() * 9]; i++) {
                int temp = (int) Math.random() * 9;
                floorsArray[temp].pplOnTheFloor.add(floorsArray[temp].personGenerator());
            }
            //removing every person position from list
            wherePplAt.clear();
        }
        System.out.println("Koniec");
    }
}