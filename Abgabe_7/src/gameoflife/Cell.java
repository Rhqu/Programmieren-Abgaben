package gameoflife;

class Cell {
    private boolean alive;
    private int livingNeighbors;
    private final Cell[] neighbors;

    Cell(double probabilityToLive) {
        this.alive = Math.random() < probabilityToLive;
        this.neighbors = new Cell[8];
    }

    void addNeighbor(Cell cell) {
        for (int cellIndex = 0; cellIndex < this.neighbors.length; cellIndex++) {
            if (this.neighbors[cellIndex] == null) {
                this.neighbors[cellIndex] = cell;
                break;
            }
        }
    }

    void countLivingNeighbors() {
        int counter = 0;
        for (Cell neighbor : this.neighbors) {
            if (neighbor != null && neighbor.alive) {
                counter++;
            }
        }
        this.livingNeighbors = counter;
    }

    void applyRules() {
        if (this.livingNeighbors < 2 || this.livingNeighbors > 3) {
            this.alive = false;
        }
        if (this.livingNeighbors == 3) {
            this.alive = true;
        }
    }

    String asString() {
        return this.alive ? "X" : " ";
    }

}
