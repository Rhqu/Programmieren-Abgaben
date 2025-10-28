package coordinates;

public class Coordinates {
    public static void main(String[] args) {
        int maxX = 6;
        int maxY = 5;

        for (int i = 1; i <= maxX; i++) {
            for (int k = 1; k <= maxY; k++) {
                System.out.printf("(%d,%d) ", i, k);
            }
            System.out.println();
        }
    }
}
