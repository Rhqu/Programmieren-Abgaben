package indianajones.gamepieces;

import indianajones.game.GameView;

public class Jones extends GamePiece {
    GameView gameView;
    boolean grail;

    public Jones(int lines, int columns, GameView gameView) {
        super(lines, columns);
        letter = 'J';
        line = 0;
        column = columns / 2;
    }

    boolean samePositionAs(GamePiece gamePiece) {
        return line == gamePiece.line && column == gamePiece.column;
    }
}
