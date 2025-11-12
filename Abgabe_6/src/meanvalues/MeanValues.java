package meanvalues;

public class MeanValues {
    static double mean(int a, int b, int c) {
        double mean = (a + b + c) / 3d;
        return  mean;
    }

    static int median(int a, int b, int c) {
        int median = 0;
        if ((a >= b) && (b >= c) || (c >= b) && (b >= a)) {
            median = b;
        } else if ((a >= c) && (c >= b) || (b >= c) && (c >= a)) {
            median = c;
        } else if ((b >= a) && (a >= c) || (c >= a) && (a >= b)) {
            median = a;
        }
        return median;
    }

    static int modal(int a, int b, int c) {
        int modal = a;
        if (b == c) {
            modal = b;
        }
        return modal;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int c = 9;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.printf("Mean: %.1f\n", Math.round(mean(a, b, c) * 10) / 10d);
        System.out.printf("Median: %d\n", median(a, b, c));
        System.out.printf("Modal: %d\n", modal(a, b, c));
    }
}
