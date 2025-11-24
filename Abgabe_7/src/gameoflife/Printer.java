package gameoflife;

class Printer {
    private final PetriDish petriDish;
    private final boolean useGameView;
    private GameView gameView;

    Printer(PetriDish petriDish, boolean useGameView) {
        this.petriDish = petriDish;
        this.useGameView = useGameView;
        if (useGameView) {
            gameView = new GameView();
        }
    }

    void printPetriDish() {
        if (useGameView) {
            gameView.plotTerminal(petriDish.asString(false), "L");
        } else {
            System.out.println(petriDish.asString(true));
        }
    }

}
