package indianajones.game;

import indianajones.gamepieces.GamePiece;

import indianajones.gamepieces.Snake;

public class Game extends GameElements {
    private boolean gameOver;
    private boolean jonesWonTheGame;

    public Game(GameView gameView, int lines, int columns, int numberOfSnakes) {
        super(gameView, lines, columns, numberOfSnakes);
    }

    public void nextIteration() {
        if (!gameOver) {
            moveAllGamePieces();
            updateGameLogic();
        }
    }

    private void moveAllGamePieces() {
        for (GamePiece gamePiece : super.allGamePieces) {
            gamePiece.move();
        }
    }

    private void updateGameLogic() {
        if (jones.hasSamePositionAs(grail)) {
            grail.beInvisible();
            jones.grail = true;
        }
        for (Snake snake : snakes) {
            if (jones.hasSamePositionAs(snake)) {
                jonesWonTheGame = false;
                gameOver = true;
            }
        }
        if (jones.hasSamePositionAs(exit)) {
            if (jones.grail) {
                gameOver = true;
                jonesWonTheGame = true;
            }
        }
    }

    @Override
    char charAtPosition(int line, int column) {
        if (!gameOver) {
            return super.charAtPosition(line, column);
        }
        if (jonesWonTheGame) {
            return 'J';
        } else {
            return 'S';
        }
    }
}
