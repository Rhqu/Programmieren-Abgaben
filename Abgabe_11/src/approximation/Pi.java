package approximation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Pi {
    MathContext mathContext;
    final BigDecimal sixteen;
    final BigDecimal four;
    final BigDecimal five;
    final BigDecimal six;
    final BigDecimal eight;

    Pi(int precision) {
        this.mathContext = new MathContext(precision, RoundingMode.HALF_UP);
        this.sixteen = new BigDecimal("16");
        this.four = new BigDecimal("4");
        this.five = new BigDecimal("5");
        this.six = new BigDecimal("6");
        this.eight = new BigDecimal("8");
    }

    BigDecimal approximatePi(int n) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal scope = BigDecimal.ZERO;
        for (int i = 0; i < n; i++) {
            BigDecimal sixteenPowK = BigDecimal.ONE.divide(sixteen.pow(i, mathContext), mathContext);
            BigDecimal eightTimesK = eight.multiply(BigDecimal.valueOf(i), mathContext);
            scope = scope.add(four.divide(eightTimesK.add(BigDecimal.ONE), mathContext), mathContext);
            scope = scope.subtract(BigDecimal.TWO.divide(eightTimesK.add(four), mathContext), mathContext);
            scope = scope.subtract(BigDecimal.ONE.divide(eightTimesK.add(five), mathContext), mathContext);
            scope = scope.subtract(BigDecimal.ONE.divide(eightTimesK.add(six), mathContext), mathContext);
            result = result.add(sixteenPowK.multiply(scope, mathContext), mathContext);
            scope = BigDecimal.ZERO;
        }
        return result;
    }

    public static void main(String[] args) {
        Pi newPi = new Pi(500);
        BigDecimal piWithPrecision = newPi.approximatePi(5000);
        System.out.print(piWithPrecision);
    }
}
