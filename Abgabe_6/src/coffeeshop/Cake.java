package coffeeshop;

public class Cake {
    String name;
    int pieces;
    double pricePerPiece;

    Cake(String name, int pieces, double pricePerPiece) {
        this.name = name;
        this.pieces = pieces;
        this.pricePerPiece = pricePerPiece;
    }

    public boolean hasPieces() {
        return this.pieces > 0;
    }

    public void takePiece() {
        if (this.pieces > 0) {
            this.pieces--;
        }
    }

    public double calculateRestPrice() {
        return Math.round(this.pieces * this.pricePerPiece * 10) / 10d;
    }

    public void print() {
        System.out.printf("%s mit %d Stücken. Der restliche Kuchen hat einen Wert von %.1f Euro.\n", this.name, this.pieces, calculateRestPrice());
    }
}
