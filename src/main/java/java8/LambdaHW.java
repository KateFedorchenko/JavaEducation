package java8;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.*;

public class LambdaHW {
    public static interface SAMExample {
        double doSmth(String str);
    }

    public static void main(String[] args) {
        /**
         * Lambda example
         */
        SAMExample example = str -> {
            BigDecimal bigDecimal = new BigDecimal(str).pow(3);
            double toDouble = bigDecimal.doubleValue();
            double result = Math.sqrt(toDouble);
            return result;
        };
        System.out.println(example.doSmth("2"));

        /**
         * Composite function example
         */
        Function<String, BigDecimal> bigDecimalWrapper = str -> new BigDecimal(str);
        UnaryOperator<BigDecimal> powOperation = x -> x.pow(3);
        Function<BigDecimal, Double> toDouble = x -> x.doubleValue();
        UnaryOperator<Double> sqrRoot = x -> Math.sqrt(x);
        Function<String, Double> result = bigDecimalWrapper.andThen(powOperation).andThen(toDouble).andThen(sqrRoot);
        System.out.println(result.apply("2"));

        /**
         * Function executes time of Runnable performance
         */
//        Runnable r = () -> System.out.println("hello");

//        Runnable r = () -> {
//            BigInteger bigInteger = new BigInteger("1");
//            for (int i = 0; i < 1000000000; i++) {
//                bigInteger.pow(i);
//            }
//        };

        int[] arr = new int[]{1, 2, 3, 7, 2, 9, 2, 99, 10};
        measureTime(() -> Arrays.sort(arr));
    }

    public static void measureTime(Runnable r) {
        long startTime = System.nanoTime();
        r.run();
        long stopTime = System.nanoTime();
        System.out.println("The execution took " + (stopTime - startTime) + " nanoseconds");
    }
}
//1) composite function to me made which can take String and transfer it to BigDecimal
// and 3th power and take sqr root and transfer it to Double (make it within one lambda)
//2) make a function which measures execution time of any Runnable!