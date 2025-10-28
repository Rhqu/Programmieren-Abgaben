package algorithm;

public class Algorithm {
    public static void main(String[] args) {
        int a = 205;
        int b = 10;
        int ergebnis;
        System.out.println("int a: " + a);
        System.out.println("int b: " + b);
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        if (b == 0) {
            ergebnis = a;
        } else {
            ergebnis = b;
        }
        System.out.println("Ergebnis: " + ergebnis);

    }
}
