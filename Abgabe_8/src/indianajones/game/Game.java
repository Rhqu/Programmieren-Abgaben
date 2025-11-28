package indianajones.game;

import indianajones.gamepieces.GamePiece;

public class Game extends GameElements {
    public Game(GameView gameView, int lines, int columns, int numberOfSnakes) {
        super(gameView, lines, columns, numberOfSnakes);
    }

    public void nextIteration() {
        moveAllGamePieces();
    }

    void moveAllGamePieces() {
        for (GamePiece gamePiece : super.allGamePieces) {
            gamePiece.move();
        }
    }
}
