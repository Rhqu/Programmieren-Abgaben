package gameoflife;

public class GameOfLife {
    // Konfiguration des Spiels
    private static final int LINES = 90;
    private static final int COLUMNS = 160;
    private static final double PROBABILITY_TO_LIVE = 0.4;
    private static final int NUMBER_OF_GENERATIONS = 10_000;
    private static final boolean USE_GAMEVIEW = true;

    public static void main(String[] args) {
        new GameOfLife().startGame();
    }

    private PetriDish petriDish;
    private Printer printer;

    private GameOfLife() {
        this.petriDish = new PetriDish(LINES, COLUMNS, PROBABILITY_TO_LIVE);
        this.printer = new Printer(petriDish, USE_GAMEVIEW);
    }

    private void startGame() {
        printer.printPetriDish();
        for (int generation = 2; generation <= NUMBER_OF_GENERATIONS; generation++) {
            petriDish.nextGeneration();
            printer.printPetriDish();
        }
    }
}
