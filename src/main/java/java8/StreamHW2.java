package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamHW2 {
    static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        int x = 0 - Integer.MIN_VALUE;// variable overflow
//        System.out.println(x);
//        printRandomNumbersDESCAbsoluteValues2();

        createHMByGroupingKeysDESCAndDistinctValues();
    }


    /**
     * Collect to List<Integer> all prime numbers between 1 and 1_000_000
     */
    private static void addToListPrimeNumbers() {
        List<Integer> integerList;
        integerList = IntStream.rangeClosed(1, 1_000_000)
                .filter(StreamHW2::isPrime)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integerList);
    }

    /**
     * Using random generator generate 1000 numbers and collect all generated numbers without first 100.
     */
    private static void excludeSomeNumbersFromStream() {
        Random random = new Random();
        List<Integer> randomInts = new ArrayList<>();
        random.ints()
                .limit(1000)
                .skip(100)
                .forEach(s -> randomInts.add(s));
        System.out.println(randomInts);
    }

    /**
     * Using random generator print to console all numbers in DESCENDING order.
     */
    private static void printRandomNumbersDESC() {
        Random random = new Random();
        List<Integer> collect = random.ints()
                .limit(10)
                .boxed()
                .sorted(Comparator.<Integer>naturalOrder().reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * Using random generator print to console all numbers in DESCENDING of its absolute value.
     */
    private static void printRandomNumbersDESCAbsoluteValues() {
        Random random = new Random();
        List<Integer> collect = random.ints()
                .limit(10)
                .boxed()
                .sorted(Comparator.comparingInt((Integer x) -> Math.abs(x)).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void printRandomNumbersDESCAbsoluteValues2() {
        Random random = new Random();
        List<Integer> collect = random.ints()
                .limit(10).boxed()
                .sorted((lhs, rhs) -> Integer.compare(Math.abs(rhs), Math.abs(lhs)))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * Given list of Strings collect them into Map<Character, List<String>> where key is lowercase first letter of String.
     *      e.g. [foo, bar, few, boo, xyz] -> {f=[foo,few], b=[bar,boo], x=[xyz]}.
     */
    private static void createHMByGroupingKeys() {
        List<String> stringList = new ArrayList<>(List.of("foo", "bar", "few", "boo", "xyz"));
        Map<Character, List<String>> characterListMap = stringList.stream()
                .collect(Collectors.groupingBy(d -> d.toLowerCase().charAt(0)));
        System.out.println(characterListMap);
    }

    /**
     * Given list of Strings collect them into Map<Character, List<String>> where key is lowercase first letter of String.
     *      e.g. [foo, bar, few, boo, xyz] -> {f=[foo,few], b=[bar,boo], x=[xyz]}.
     * Make resulting lists in ascending order and without duplicates.
     */
    private static void createHMByGroupingKeysDESCAndDistinctValues() {
        List<String> stringList = new ArrayList<>(List.of("foo", "Foo", "foo", "Bar", "few", "boo", "xyz"));
        Map<Character, List<String>> collect = stringList.stream()
                .sorted()
                .distinct()
                .collect(Collectors.groupingBy(d -> d.toLowerCase().charAt(0)));
        System.out.println(collect);
    }

}
