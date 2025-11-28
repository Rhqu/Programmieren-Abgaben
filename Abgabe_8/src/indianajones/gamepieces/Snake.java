package indianajones.gamepieces;

public class Snake extends GamePiece {
    Jones jones;

    public Snake(int lines, int columns, Jones jones) {
        super(lines, columns);
        this.jones = jones;
        letter = 'S';
        line = (int) (Math.random() * lines);
        column = columns - 1;
    }

    @Override
    void move() {
        double randomWalk = Math.random();
        if (this.line + 1 == jones.getLine()) {
            this.line += 1;
        } else if (this.line - 1 == jones.getLine()) {
            this.line -= 1;
        } else if (this.column + 1 == jones.getColumn()) {
            this.column += 1;
        } else if (this.column - 1 == jones.getColumn()) {
            this.column -= 1;
        }
        if (randomWalk > 0.5) {
            if (this.line < jones.getLine()) {
                this.line += 1;
            } else if (this.line > jones.getLine()) {
                this.line -= 1;
            }
        } else {
            if (this.column < jones.getColumn()) {
                this.column += 1;
            } else if (this.column > jones.getColumn()) {
                this.column -= 1;
            }
        }
    }
}
