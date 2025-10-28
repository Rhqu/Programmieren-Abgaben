package triplets;

import java.util.Arrays;

;

public class Triplets {
    public static void main(String[] args) {
        int[] triplets = new int[3];
        int counter = 1;
        while (true) {
            triplets[0] = 1 + (int) (Math.random() * 6);
            triplets[1] = 1 + (int) (Math.random() * 6);
            triplets[2] = 1 + (int) (Math.random() * 6);

            System.out.printf("Wurf: %d: %d, %d, %d\n", counter, triplets[0], triplets[1], triplets[2]);
            counter++;
            double sumOfTriplets = triplets[0] + triplets[1] + triplets[2];
            if (sumOfTriplets == 3 * triplets[0]){
                System.out.print("Tripel!");
                break;
            }
        }
    }
}
