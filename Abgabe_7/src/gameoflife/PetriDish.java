package gameoflife;


class PetriDish {
    private final Cell[][] cells;
    private final int lines;
    private final int columns;
    private int generationNumber;

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
        if (withinBoundaries(line, column - 1)) {
            this.cells[line][column].addNeighbor(this.cells[line][column - 1]);
        }
        if (withinBoundaries(line, column + 1)) {
            this.cells[line][column].addNeighbor(this.cells[line][column + 1]);
        }
        if (withinBoundaries(line - 1, column)) {
            this.cells[line][column].addNeighbor(this.cells[line - 1][column]);
        }
        if (withinBoundaries(line + 1, column)) {
            this.cells[line][column].addNeighbor(this.cells[line + 1][column]);
        }
        if (withinBoundaries(line - 1, column - 1)) {
            this.cells[line][column].addNeighbor(this.cells[line - 1][column - 1]);
        }
        if (withinBoundaries(line + 1, column + 1)) {
            this.cells[line][column].addNeighbor(this.cells[line + 1][column + 1]);
        }
        if (withinBoundaries(line - 1, column + 1)) {
            this.cells[line][column].addNeighbor(this.cells[line - 1][column + 1]);
        }
        if (withinBoundaries(line + 1, column - 1)) {
            this.cells[line][column].addNeighbor(this.cells[line + 1][column - 1]);
        }


    }

    private boolean withinBoundaries(int line, int column) {
        if (line >= this.cells.length || line < 0) {
            return false;
        }
        return column < this.cells[line].length && column >= 0;
    }

    private void addNeighborsToAllCells() {
        for (int line = 0; line < this.lines; line++) {
            for (int column = 0; column < this.columns; column++) {
                addNeighborsToCellIn(line, column);
            }
        }
    }

    void nextGeneration() {
        countLivingNeighborsOfAllCells();
        applyRulesToAllCells();
        generationNumber++;
    }

    private void countLivingNeighborsOfAllCells() {
        for (int line = 0; line < this.lines; line++) {
            for (int column = 0; column < this.columns; column++) {
                this.cells[line][column].countLivingNeighbors();
            }
        }
    }

    private void applyRulesToAllCells() {
        for (int line = 0; line < this.lines; line++) {
            for (int column = 0; column < this.columns; column++) {
                this.cells[line][column].applyRules();
            }
        }
    }

    String asString(boolean showHeadline) {
        String table = "";
        if (showHeadline) {
            table += "Generation: " + this.generationNumber + "\n";
        }
        for (int line = 0; line < this.lines; line++) {
            for (int column = 0; column < this.columns; column++) {
                table += this.cells[line][column].asString();
            }
            table += "\n";
        }
        return table;
    }
}
