package frograce.printer;

import frograce.game.Game;

public class GameViewPrinter {

    private int trackDistanceInCm;
    private Game game;
    private GameView gameView;

    public GameViewPrinter(Game game, int trackDistanceInCm) {
        this.game = game;
        this.trackDistanceInCm = trackDistanceInCm;
        gameView = new GameView();
    }

    public void printAndSleep(int sleepTimeInMilliseconds) {
        gameView.plotTerminal(game.toString(), "M");
        try {
            Thread.sleep(sleepTimeInMilliseconds);
        } catch (InterruptedException ignored) {
        }
    }
}
