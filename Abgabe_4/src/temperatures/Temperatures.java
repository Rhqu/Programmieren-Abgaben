package temperatures;

import java.util.Arrays;

public class Temperatures {
    public static void main(String[] args) {
        double[] minimumTemperatures = new double[30];
        double[] maximumTemperatures = new double[30];
        for (int i = 0; i < minimumTemperatures.length; i++) {
            minimumTemperatures[i] = 1 + Math.random() * 13;
            maximumTemperatures[i] = 5 + Math.random() * 15;
        }
        System.out.println("Unsortiert: ");
        for (int i = 0; i < minimumTemperatures.length; i++) {
            System.out.printf("Tag %d: Minimum = %f, Maximum = %f\n", i + 1, minimumTemperatures[i], maximumTemperatures[i]);
        }
        for (int i = 0; i < minimumTemperatures.length; i++) {
            double tmp = 0;
            if (minimumTemperatures[i] > maximumTemperatures[i]) {
                tmp = maximumTemperatures[i];
                maximumTemperatures[i] = minimumTemperatures[i];
                minimumTemperatures[i] = tmp;
                tmp = 0;
            }
        }
        System.out.println();
        System.out.println("Sortiert: ");
        for (int i = 0; i < minimumTemperatures.length; i++) {
            System.out.printf("Tag %d: Minimum = %f, Maximum = %f\n", i + 1, minimumTemperatures[i], maximumTemperatures[i]);
        }
    }
}
