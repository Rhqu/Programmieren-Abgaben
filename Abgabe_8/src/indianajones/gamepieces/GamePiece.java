package indianajones.gamepieces;

public class GamePiece {
    final int lines;
    final int columns;
    int line;
    int column;
    char letter;

    public GamePiece(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
    }

    public void move() {
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;

    }

    public char getLetter() {
        return this.letter;
    }
}

