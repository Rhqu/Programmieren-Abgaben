package exponentialgrowth;

import java.math.BigInteger;

public class ExponentialGrowth {
    private void printInt() {
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " (int): " + (int) Math.pow(10, i));
        }
    }

    private void printLong() {
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " (long): " + (long) Math.pow(10, i));
        }
    }

    private void printBigInteger() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " (BigInteger): " + BigInteger.TEN.pow(i));
        }
    }

    public static void main(String[] args) {
        ExponentialGrowth exp = new ExponentialGrowth();
        exp.printInt();
        exp.printLong();
        exp.printBigInteger();
    }
}
