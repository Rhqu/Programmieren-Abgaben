package indianajones.game;


import indianajones.gamepieces.*;

import java.util.Arrays;


public class GameElements extends GameField {
    Jones jones;
    Exit exit;
    Grail grail;
    Snake[] snakes;
    GamePiece[] allGamePieces;

    GameElements(GameView gameView, int lines, int columns, int numberOfSnakes) {
        super(lines, columns, numberOfSnakes);
        this.jones = new Jones(gameView, lines, columns);
        this.exit = new Exit(this.lines, this.columns);
        this.grail = new Grail(this.lines, this.columns);
        this.snakes = new Snake[numberOfSnakes];
        Arrays.fill(snakes, new Snake(this.lines, this.columns, this.jones));
        allGamePieces = new GamePiece[3 + numberOfSnakes];
        allGamePieces[0] = jones;
        allGamePieces[1] = grail;
        allGamePieces[2] = exit;
        for (int i = 0; i < numberOfSnakes; i++) {
            allGamePieces[i + 3] = snakes[i];
        }
    }

    @Override
    char charAtPosition(int line, int column) {
        for (GamePiece gamePiece : allGamePieces) {
            if (gamePiece.getLine() == line && gamePiece.getColumn() == column) {
                return gamePiece.getLetter();
            }
        }
        return super.charAtPosition(line, column);
    }
}
