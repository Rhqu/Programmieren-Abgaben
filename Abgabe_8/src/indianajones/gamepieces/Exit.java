package indianajones.gamepieces;

public class Exit extends GamePiece {
    public Exit(int lines, int columns) {
        super(lines, columns);
        letter = 'E';
        column = columns - 1;
        line = lines / 2;
    }

}
