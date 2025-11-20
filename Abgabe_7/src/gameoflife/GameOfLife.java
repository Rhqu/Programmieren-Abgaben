package gameoflife;

public class GameOfLife {
    // Konfiguration des Spiels
    private static final int LINES = 10;
    private static final int COLUMNS = 15;
    private static final double PROBABILITY_TO_LIVE = 0.4;
    private static final int NUMBER_OF_GENERATIONS = 10;
    private static final boolean USE_GAMEVIEW = false;
    public static void main(String[] args) {
        new GameOfLife().startGame();
    }
    private PetriDish petriDish;
    private Printer printer;
    private GameOfLife() {
// Erzeugen Sie die beiden Instanzvariablen
    }
    private void startGame() {
// Geben Sie die Start-Generation aus.
// Laufen Sie in einer for-Schleife durch die Generationen
// (von 2 bis NUMBER_OF_GENERATIONS) und geben Sie die jeweilige
// Generation aus.
    }
}
