package frograce.printer;

import frograce.game.Game;

public class GameViewPrinter {

    private final Game game;
    private final GameView gameView;

    public GameViewPrinter(Game game, int trackDistanceInCm) {
        this.game = game;
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
