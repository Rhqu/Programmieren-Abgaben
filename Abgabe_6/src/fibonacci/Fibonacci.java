package fibonacci;

import java.util.Arrays;

public class Fibonacci {
    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fibonacciLoop(int n) {
        int temp = 0;
        int firstNumber = 1;
        int nextNumber = 0;
        for (int i = 0; i < n; i++) {
            nextNumber = nextNumber + firstNumber;
            temp = firstNumber;
            firstNumber = nextNumber;
            nextNumber = temp;
        }
        return nextNumber;
    }

    static int[] fibonacciSequence(int n, int m) {
        int[] sequence = new int[m - n + 1];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = fibonacci(n);
            n++;
        }
        return sequence;
    }

    public static void main(String[] args) {
        int n = 21;
        int m = 25;
        int fib = fibonacci(n);
        int fibLoop = fibonacciLoop(n);
        int[] fibSequence = fibonacciSequence(n, m);
        System.out.printf("fibonacci(%d) = %d\n", n, fib);
        System.out.printf("fibonacciLoop(%d) = %d\n", n, fibLoop);
        System.out.printf("fibonacciSequence(%d, %d) = " + Arrays.toString(fibSequence), n, m);
    }
}
