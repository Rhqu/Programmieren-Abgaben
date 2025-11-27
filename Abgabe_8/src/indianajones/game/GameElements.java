package indianajones.game;


import indianajones.gamepieces.*;

import java.util.Arrays;


public class GameElements extends GameField {
    Jones jones;
    Exit exit;
    Grail grail;
    Snake[] snake;
    GamePiece[] allGamePieces;

    GameElements(GameView gameView, int lines, int columns, int numberOfSnakes) {
        super(lines, columns, numberOfSnakes);
        this.jones = new Jones(lines, columns, gameView);
        this.exit = new Exit(this.lines, this.columns);
        this.grail = new Grail(this.lines, this.columns);
        this.snake = new Snake[numberOfSnakes];
        allGamePieces[0] = jones;
        allGamePieces[1] = grail;
        allGamePieces[2] = exit;
        for (int i = 0; i < numberOfSnakes; i++) {
            allGamePieces[i + 3] = snake[i];
        }
    }

    char charAtPosition(int line, int column) {
        for (GamePiece gamePiece : allGamePieces) {
            if (gamePiece.line == line && gamePiece.column == column) {
                return gamePiece.getLetter();
            }
        }
        return super.charAtPosition(line, column);
    }
}
