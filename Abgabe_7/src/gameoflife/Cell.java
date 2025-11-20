package gameoflife;

public class Cell {
    boolean alive;
    int livingNeighbors;
    Cell[] neighbors;

    public Cell(double probabilityToLive) {
        this.alive = Math.random() < probabilityToLive;
        this.neighbors = new Cell[8];
    }

    public void addNeighbor(Cell cell) {
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

    public void applyRules() {
        if (this.livingNeighbors < 2 || this.livingNeighbors > 3) {
            this.alive = false;
        }
        if (this.livingNeighbors == 3) {
            this.alive = true;
        }
    }

    public String asString() {
        return this.alive ? "X" : " ";
    }

}
