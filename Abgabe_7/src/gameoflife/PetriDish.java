package gameoflife;


import javax.swing.*;

public class PetriDish {
    Cell[][] cells;
    int lines;
    int columns;
    int generationNumber;

    PetriDish(int columns, int lines, double probabilityToLive){
        this.lines = lines;
        this.columns = columns;
        this.generationNumber = 1;
        this.cells = new Cell[lines][columns];
        createAllCells(probabilityToLive);
    }
    public void createAllCells(double probabilityToLive){
        for (int i = 0; i < lines; i++){
            for (int k = 0; k < columns; k++){
                cells[i][k] = new Cell(probabilityToLive);
            }
        }
    }
    public void addNeighborsToCellIn(int line, int column){

    }
    public void addNeighborsToAllCells(){

    }
}
