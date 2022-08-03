package java8;

public class StreamHW2 {
    /*
     * 1. Collect to List<Integer> all prime numbers between 1 and 1_000_000
     * 2. Using random generator generate 1000 numbers and collect all generated numbers without first 100;
     * 3. Using random generator print to console all numbers in DESCENDING order
     * 3*.Using random generator print to console all numbers in DESCENDING of its absolute value
     */

    static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
    }
}
