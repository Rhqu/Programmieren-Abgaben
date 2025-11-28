package indianajones.game;

public class GameField {
    protected int lines;
    protected int columns;
    protected int numberOfSnakes;

    public GameField(int lines, int columns, int numberOfSnakes) {
        this.lines = lines;
        this.columns = columns;
        this.numberOfSnakes = numberOfSnakes;
    }

    @Override
    public String toString() {
        StringBuilder table = new StringBuilder(lines * columns);
        for (int line = 0; line < this.lines; line++) {
            for (int column = 0; column < this.columns; column++) {
                table.append(charAtPosition(line, column));
            }
        }
        return table.toString();
    }

    char charAtPosition(int line, int column) {
        return ' ';
    }
}
