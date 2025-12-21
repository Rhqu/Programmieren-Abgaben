package experiments;

public class CubicBinomialExpansion {
    boolean useCompactForm;

    void useCompactForm() {
        this.useCompactForm = true;
    }

    void useExpandedForm() {
        this.useCompactForm = false;
    }

    String description() {
        if (useCompactForm) {
            return "(a + b)³";
        } else {
            return "a³ + 3a²b + 3ab² + b³";
        }
    }

    double calculate(double a, double b) {
        if (useCompactForm) {
            return Math.pow((a + b), 3);
        } else {
            return Math.pow(a, 3) + 3 * Math.pow(a, 2) * b + 3 * a * Math.pow(b, 2) + Math.pow(b, 3);
        }
    }
}
