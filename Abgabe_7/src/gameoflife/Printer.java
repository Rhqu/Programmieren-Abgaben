package gameoflife;

public class Printer {
    PetriDish petriDish;
    boolean useGameView;
    GameView gameView;

    Printer(PetriDish petriDish, GameView gameView){
        this.petriDish = petriDish;
        this.gameView = gameView;
    }
    void printPetriDish(){
        gameView.plotTerminal(this.petriDish.asString(true), "S");
    }

}
