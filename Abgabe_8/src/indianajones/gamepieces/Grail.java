package indianajones.gamepieces;


public class Grail extends GamePiece {

    public Grail(int lines, int columns) {
        super(lines, columns);
        letter = 'G';
        column = (int) (Math.random() * columns);
        line = (int) (Math.random() * lines);
    }

    public void beInvisible() {
        this.letter = ' ';
    }
}
