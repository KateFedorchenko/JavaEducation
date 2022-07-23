package java8;

import java.util.function.*;

public class LambdaDemo {
    public static interface SAMExample {
        String doSmth(int x);           // lambda may be casted only to SAM type (single abstract method)
    }

    public static void main(String[] args) {
        Runnable r = LambdaDemo::print;         //
        r.run();
        Function<Integer,String> intToString = Integer::toHexString;
        System.out.println(intToString.apply(16));

        Function<Object,String> objToString = Object::toString; // :: = reference method
        System.out.println(objToString.apply("foo"));
        Supplier<String> supplier = "foo"::toString;



    }

    public static void print() {
        System.out.println("message");
    }

    public void lambdaDiffForms() {
        SAMExample example = (int y) -> {
            return "foo";
        };
        example = y -> {
            return "foo";
        };
        example = y -> "foo";
        example.doSmth(2);
    }

    public void standardFunctionalInterfaces() {
        Runnable r = () -> System.out.println("hello");
        r.run();
        Supplier<String> supplier = () -> "foo";
        System.out.println(supplier.get());
        Consumer<String> consumer = (String x) -> System.out.println("x = " + x);
        consumer.accept("foo");
        consumer.accept("boo");

        Function<Integer, String> stringMapper = x -> x.toString();
        System.out.println(stringMapper.apply(2));

        Function<Integer, String> function1 = x -> ((Integer) (x * x)).toString();
        System.out.println(function1.apply(3));

        UnaryOperator<Integer> sqr = x -> x * x;
        System.out.println(sqr.apply(25));

        Function<Integer, String> sqrAndMapToString = sqr.andThen(stringMapper);    // composite function
        System.out.println(sqrAndMapToString.apply(2));

        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        System.out.println(sum.apply(2, 3));
    }
}
//1) composite function to me made which can take String and transfer it to BigDecimal
// and 3th power and take sqr root and transfer it to Double (make it within one lambda)
//2) make a function which measures execution time of any Runnable!