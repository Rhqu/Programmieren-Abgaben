package minimum;

public class Minimum {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        int z = -20;
        int minimumXY = (x < y) ? x : y;
        int globalMaximum = (z < minimumXY) ? z : minimumXY;
        System.out.print("x ist " + x);
        System.out.print("\ny ist " + y);
        System.out.print("\nz ist " + z);
        System.out.print("\nDas Minimum ist " + globalMaximum);
    }
}
