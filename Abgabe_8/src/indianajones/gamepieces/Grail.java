package indianajones.gamepieces;


public class Grail extends GamePiece {

    public Grail(int lines, int columns) {
        super(lines, columns);
        letter = 'G';
        column = (int) (Math.random() * columns - 1);
        line = (int) (Math.random() * lines - 1);
    }

    void beInvisible() {
        letter = ' ';
    }
}
