package indianajones.gamepieces;

import indianajones.game.GameView;

public class Jones extends GamePiece {
    GameView gameView;
    boolean grail;

    public Jones(GameView gameView, int lines, int columns) {
        super(lines, columns);
        letter = 'J';
        line = lines  / 2;
        column = 0;
    }

    boolean hasSamePositionAs(GamePiece gamePiece) {
        return (this.line == gamePiece.getLine() && this.column == gamePiece.getColumn());
    }
}
