package indianajones.gamepieces;

import static java.awt.event.KeyEvent.*;

import indianajones.game.GameView;

public class Jones extends GamePiece {
    private final GameView gameView;
    public boolean grail;

    public Jones(GameView gameView, int lines, int columns) {
        super(lines, columns);
        letter = 'J';
        line = lines / 2;
        column = 0;
        this.gameView = gameView;
    }

    public boolean hasSamePositionAs(GamePiece gamePiece) {
        return (this.line == gamePiece.getLine() && this.column == gamePiece.getColumn());
    }

    @Override
    public void move() {
        if (gameView.keyCurrentlyPressed(VK_UP)) {
            if (line > 0) {
                this.line -= 1;
            }
        }
        if (gameView.keyCurrentlyPressed(VK_DOWN)) {
            if (line < this.lines - 1) {
                this.line += 1;
            }
        }
        if (gameView.keyCurrentlyPressed(VK_LEFT)) {
            if (column > 0) {
                this.column -= 1;
            }

        }
        if (gameView.keyCurrentlyPressed(VK_RIGHT)) {
            if (column < this.columns - 1) {
                this.column += 1;
            }
        }
    }
}
