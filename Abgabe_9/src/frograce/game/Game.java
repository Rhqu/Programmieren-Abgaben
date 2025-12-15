package frograce.game;

public class Game {
    private final Track track;
    private final Frog[] frogs;
    private Frog winningFrog;
    private boolean gameOver;

    public void nextIteration() {
        shuffleFrogs();
        letFrogsJumpAndCheckForWinner();
    }

    private void shuffleFrogs() {
        Frog tmp;
        Frog frogRandom;
        int randomIndex;
        for (int i = 0; i < frogs.length; i++) {
            tmp = frogs[i];
            randomIndex = (int) (Math.random() * frogs.length);
            frogRandom = frogs[randomIndex];
            frogs[i] = frogRandom;
            frogs[randomIndex] = tmp;
        }
    }

    private void letFrogsJumpAndCheckForWinner() {
        for (Frog frog : frogs) {
            frog.jump();
            if (frog.getCurrentDistanceInCm() >= track.getDistanceInCm()) {
                winningFrog = frog;
                gameOver = true;
                break;
            }
        }
    }

    public Game(String trackName, int distanceInCm, Frog[] frogs) {
        this.track = new Track(trackName, distanceInCm, frogs.clone());
        this.frogs = frogs;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append(this.track.toString());
        if (gameOver) {
            returnString.append(winningFrog.getName()).append(" hat gewonnen!");
        }
        return returnString.toString();
    }

}
