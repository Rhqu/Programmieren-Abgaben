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

    void moveAllGamePieces() {
        for (GamePiece gamePiece : super.allGamePieces) {
            gamePiece.move();
        }
    }

    void updateGameLogic() {
        if (jones.hasSamePositionAs(grail)) {
            grail.beInvisible();
            jones.grail = true;
        }
        for (Snake snake : super.snakes) {
            if (jones.hasSamePositionAs(snake)) {
                jonesWonTheGame = false;
            }
        }
        if (jones.hasSamePositionAs(exit)) {
            if(jones.grail){
                gameOver = true;
                jonesWonTheGame = true;
            }
        }
    }

    @Override
    char charAtPosition(int lines, int columns) {
        if (!gameOver) {
            return super.charAtPosition(lines, columns);
        }
        if (jonesWonTheGame) {
            return 'J';
        } else {
            return 'S';
        }
    }
}
