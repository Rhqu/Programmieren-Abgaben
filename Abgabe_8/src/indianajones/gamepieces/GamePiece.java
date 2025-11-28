package indianajones.gamepieces;

public class GamePiece {
    private final int lines;
    private final int columns;
    public int line;
    public int column;
    char letter;

    public GamePiece(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
    }

    void move() {
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

