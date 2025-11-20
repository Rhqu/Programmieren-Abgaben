package gameoflife;


public class PetriDish {
    Cell[][] cells;
    int lines;
    int columns;
    int generationNumber;

    public PetriDish(int lines, int columns, double probabilityToLive) {
        this.lines = lines;
        this.columns = columns;
        this.generationNumber = 1;
        this.cells = new Cell[lines][columns];
        createAllCells(probabilityToLive);
        addNeighborsToAllCells();
    }

    private void createAllCells(double probabilityToLive) {
        for (int i = 0; i < lines; i++) {
            for (int k = 0; k < columns; k++) {
                this.cells[i][k] = new Cell(probabilityToLive);
            }
        }
    }

    private void addNeighborsToCellIn(int line, int column) {
        if (this.cells[column][line].alive) {
            if (withinBoundaries(column, line - 1)) {
                if (this.cells[column][line - 1].alive) {
                    this.cells[column][line].addNeighbor(this.cells[column][line - 1]);
                }
            }
            if (withinBoundaries(column, line + 1)) {
                if (this.cells[column][line + 1].alive) {
                    this.cells[column][line].addNeighbor(this.cells[column][line + 1]);
                }
            }
        }

    }

    private boolean withinBoundaries(int line, int column) {
        if (!(column <= this.cells.length)) {
            return false;
        }
        return line <= this.cells[column].length;
    }

    private void addNeighborsToAllCells() {
        for (int column = 0; column < this.columns; column++) {
            for (int line = 0; line < this.lines; line++) {
                addNeighborsToCellIn(line, column);
            }
        }
    }

    public void nextGeneration() {
        countLivingNeighborsOfAllCells();
        applyRulesToAllCells();
        generationNumber++;
    }

    private void countLivingNeighborsOfAllCells() {
        for (int column = 0; column < this.columns; column++) {
            for (int line = 0; line < this.lines; line++) {
                this.cells[column][line].countLivingNeighbors();
            }
        }
    }

    private void applyRulesToAllCells() {
        for (int column = 0; column < this.columns; column++) {
            for (int line = 0; line < this.lines; line++) {
                this.cells[column][line].applyRules();
            }
        }
    }

    String asString(boolean showHeadline) {
        StringBuilder table = new StringBuilder();
        if (showHeadline) {
            System.out.println("Generation: " + this.generationNumber);
        }
        for (int column = 0; column < this.columns; column++) {
            for (int line = 0; line < this.lines; line++) {
                table.append(this.cells[column][line].asString());
            }
            table.append("\n");
        }
        return table.toString();
    }
}
