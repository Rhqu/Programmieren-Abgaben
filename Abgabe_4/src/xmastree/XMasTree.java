package xmastree;

public class XMasTree {
    public static void main(String[] args) {
        int height = 5;
        for (int i = 0; i < height; i++) {
            System.out.print(" ");
        }
        System.out.println("+");
        int starsInLine = 1;
        for (int line = 0; line < height; line++) {
            for (int space = 0; space < height - line; space++) {
                System.out.print(" ");
            }
            for (int star = 0; star < starsInLine; star++) {
                System.out.print("*");
            }
            System.out.println();
            starsInLine += 2;
        }
        for (int i = 0; i < height; i++) {
            System.out.print(" ");
        }
        System.out.print("U");
    }
}
