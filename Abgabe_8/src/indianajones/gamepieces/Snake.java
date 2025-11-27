package indianajones.gamepieces;

public class Snake extends GamePiece {
    Jones jones;

    Snake(int lines, int columns, Jones jones) {
        super(lines, columns);
        this.jones = jones;
        letter = 'S';
        line = (int) (Math.random() * lines);
        column = columns - 1;
    }
}
