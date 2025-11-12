package games.dice;

public class Dice {
    private String color;
    private int pips;

    public Dice(String color) {
        this.color = color;
        this.pips = -1;
    }

    public String getColor() {
        return this.color;
    }

    public int getPips() {
        return this.pips;
    }

    public void roll() {
        this.pips = (int) (Math.random() * 6 + 1);
    }
}

