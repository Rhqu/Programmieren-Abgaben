package quiz;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberGuessed;
        int random = 1 + (int) (Math.random() * 1_000);
        long startTime = System.currentTimeMillis();
        int numberOfTries = 0;

        while (true) {
            System.out.print("Bitte eine Zahl eingeben: ");
            numberOfTries++;
            numberGuessed = scanner.nextInt();
            if (numberGuessed == random) {
                int timePassed = (int) (System.currentTimeMillis() - startTime) / 1000;
                System.out.println("Treffer!");
                System.out.println("Sie haben " + timePassed + " Sekunden benötigt");
                System.out.println("Sie haben "  + numberOfTries + " Versuche benötigt");
                break;
            } else if (numberGuessed > random) {
                System.out.println("Ihre Zahl ist zu hoch!");
            } else {
                System.out.println("Ihre Zahl ist zu niedrig!");
            }
        }
        scanner.close();
    }
}
