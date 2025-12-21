package experiments;

import java.util.Random;

class Experiments {

    private final CubicBinomialExpansion cubicBinomialExpansion;
    private final Random random;
    private int repetitions;
    private int seed;
    private double[] aValues;
    private double[] bValues;
    public long measuredExperimentDuration;

    public static void main(String[] args) {
        new Experiments().executeAndPrintResults();
    }

    Experiments() {
        cubicBinomialExpansion = new CubicBinomialExpansion();
        random = new Random();
    }

    private void executeAndPrintResults() {
        System.out.println(" --- Warmup ---");
        repetitions = 1_000_000;
        seed = 1234;
        runExperiments();

        System.out.println("\n --- Experiments ---");
        repetitions = 10_000_000;
        seed = 1492;
        runExperiments();
    }

    /**
     * Run two experiments.
     * 1. Generate input values for the calculations.
     * 2. Run the experiment with the compact form.
     * 3. Run the experiment with the expanded form.
     */
    private void runExperiments() {
        generateInputValues();
        cubicBinomialExpansion.useCompactForm();
        runExperiment();
        cubicBinomialExpansion.useExpandedForm();
        runExperiment();
    }

    /**
     * Run the experiment, measure its duration in nanoseconds and print the results.
     */
    private void runExperiment() {
        long startTime = System.nanoTime();
        performCalculations();
        long endTime = System.nanoTime();
        measuredExperimentDuration = endTime - startTime;
    }

    /**
     * Generate all input values (aValues and bValues) for the calculations. The values are random numbers between 0
     * (included) and 10 (excluded). Use the seed for the random number generator.
     */
    private void generateInputValues() {
        random.setSeed(seed);
        aValues = new double[repetitions];
        bValues = new double[repetitions];
        for (int i = 0; i < repetitions; i++) {
            aValues[i] = random.nextInt(9);
            bValues[i] = random.nextInt(9);
        }
    }

    /**
     * Perform the calculation for the given input values and the given repetitions in a for-loop.
     */
    private void performCalculations() {
        for (int i = 0; i < repetitions; i++) {
            for (int k = 0; k < aValues.length; k++) {
                cubicBinomialExpansion.calculte(aValues[k], bValues[k]);
            }
        }
    }

    private void printResult() {
        System.out.println("Form: " + cubicBinomialExpansion.description());
        System.out.println("Wiederholungen: " + repetitions);
        System.out.println("Seed: " + seed);
        System.out.println("Gesamtzeit alle Berechnungen: " + measuredExperimentDuration + " ns");
        System.out.println("Durchschnitt pro Berechnung: " + measuredExperimentDuration / repetitions + " ns\n");
    }
}
