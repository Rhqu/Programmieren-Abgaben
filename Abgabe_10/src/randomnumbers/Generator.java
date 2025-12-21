package randomnumbers;

import java.util.Random;

public class Generator {
    private int[] generateRandomNumbers(int size, int min, int max, long seed) {
        Random shuffled = new Random(seed);
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = shuffled.nextInt(max - min + 1) + min;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
