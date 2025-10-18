package triangle;

public class Triangle {
    public static void main(String[] args) {
        double a = 5.0;
        double b = 5.0;
        double c = 7.071;
        double abSquared = Math.pow(a, 2) + Math.pow(b, 2);
        double cSquared = Math.pow(c, 2);
        boolean rightAngled = Math.abs(abSquared - cSquared) < 0.1;
        System.out.print("a = " + a);
        System.out.print("\nb = " + b);
        System.out.print("\nc = " + c + "\n");
        if (rightAngled) {
            System.out.print("Das Dreieck ist rechtwinklig.");
        } else {
            System.out.print("Das Dreieck ist nicht rechtwinklig.");
        }


    }
}
