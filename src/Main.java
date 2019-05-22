import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to elevator simulation!");
        Scanner scanner = new Scanner();
        int mainIterations;
        mainIterations = scanner.nextInt();


        for (int i = 0; i < mainIterations; i++) { // main loop of our program
            int x = 10;

            for (int j = 1; j <= x; j++) {
                Random r = new Random();
                new Floor(j,r);
            }

        }
    }
}