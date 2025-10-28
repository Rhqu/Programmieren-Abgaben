package triplets;


import java.util.Arrays;

public class Triplets {
    public static void main(String[] args) {
        int[] triplets = new int[3];
        int counter = 1;
        int[] oneTriplets = {1, 1, 1};
        int[] twoTriplets = {2, 2, 2};
        int[] threeTriplets = {3, 3, 3};
        boolean tripletOfOnes = false;
        boolean tripletOfTwos = false;
        boolean tripletOfThrees = false;
        double sumOne = 0;
        double sumTwo = 0;
        double sumThree = 0;
        while (true) {
            triplets[0] = 1 + (int) (Math.random() * 6);
            triplets[1] = 1 + (int) (Math.random() * 6);
            triplets[2] = 1 + (int) (Math.random() * 6);

            System.out.printf("Wurf %d: %d, %d, %d\n", counter, triplets[0], triplets[1], triplets[2]);
            sumOne += triplets[0];
            sumTwo += triplets[1];
            sumThree += triplets[2];
            try {
                Thread.sleep(5);
            } catch (InterruptedException ignored) {
            }
            if (Arrays.equals(oneTriplets, triplets)) {
                System.out.print("Trippel!\n");
                tripletOfOnes = true;

            } else if (Arrays.equals(twoTriplets, triplets)) {
                System.out.print("Trippel!\n");
                tripletOfTwos = true;

            } else if ((Arrays.equals(threeTriplets, triplets))) {
                System.out.print("Trippel!\n");
                tripletOfThrees = true;
            } else if ((triplets[0] == triplets[1]) && (triplets[1] == triplets[2])) {
                System.out.print("Trippel!\n");
            }
            if (tripletOfOnes && tripletOfTwos && tripletOfThrees) {
                System.out.println();
                System.out.println("Alle Trippel (Einser, Zweier und Dreier) waren dabei!");
                System.out.println("Mittelwert Würfel 1: " + sumOne / counter);
                System.out.println("Mittelwert Würfel 2: " + sumTwo / counter);
                System.out.println("Mittelwert Würfel 3: " + sumThree / counter);
                break;
            }
            counter++;
        }
    }
}
