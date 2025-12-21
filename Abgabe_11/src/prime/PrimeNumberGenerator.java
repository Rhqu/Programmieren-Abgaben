package prime;

public class PrimeNumberGenerator {
    boolean numberIsPrime(long number) {
        long last = (long) Math.sqrt(number);
        if (number >= 2) {
            for (long i = 2; i <= last; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    long findNextPrimeNumber(long startNumber) {
        if (numberIsPrime(startNumber)) {
            return startNumber;
        }

        while (!numberIsPrime(startNumber)) {
            startNumber++;
        }
        return startNumber;
    }

    void printPrimeNumbers(long startNumber, int numbers) {
        for (int i = 0; i < numbers; i++) {
            long foundNumber = findNextPrimeNumber(startNumber);
            System.out.println(foundNumber);
            startNumber = foundNumber + 1;
        }
    }

    public static void main(String[] args) {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
        long startNumber = 1_000_000_000_000L;
        int numbers = 100;
        primeNumberGenerator.printPrimeNumbers(startNumber, numbers);
    }
}
