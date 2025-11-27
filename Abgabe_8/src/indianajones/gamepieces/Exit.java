package indianajones.gamepieces;

public class Exit extends GamePiece {
    public Exit(int lines, int columns) {
        super(lines, columns);
        letter = 'E';
        column -= 1;
        line /= 2;
    }

}
