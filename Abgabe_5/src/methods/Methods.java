package methods;

public class Methods {
    static boolean even(int i) {
        return i % 2 == 0;
    }

    static double pythagoras(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    static int minimum(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    static void printInfo() {
        System.out.println("--- Abgabe 5 ---");
    }

    static void printVariable(String name, int value) {
        System.out.println(name + value);
    }

    static void printRoundedDouble(String name, double roundedDouble) {
        System.out.printf(name + "%.2f\n", roundedDouble);
    }

    static void printBoolean(String name, boolean bool) {
        System.out.println(name + bool);
    }

    static void printInt(String name, int integer) {
        System.out.println(name + integer);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 20;
        printInfo();
        printVariable("int a: ", a);
        printVariable("int b: ", b);
        printVariable("int c: ", c);
        printBoolean("even(a): ", even(a));
        printRoundedDouble("pythagoras(a, b): ", pythagoras(a, b));
        printInt("minimum(a, b, c): ", minimum(a, b, c));
        printBoolean("Minimum von a, b und c ist ungerade: ", !even(minimum(a, b, c)));
        printInfo();
    }
}
