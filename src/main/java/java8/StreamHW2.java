package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamHW2 {
    /*
     * 1. Collect to List<Integer> all prime numbers between 1 and 1_000_000
     * 2. Using random generator generate 1000 numbers and collect all generated numbers without first 100;
     * 3. Using random generator print to console all numbers in DESCENDING order
     * 3*.Using random generator print to console all numbers in DESCENDING of its absolute value
     * 4. Given list of Strings collect them into Map<Character, List<String>> where key is lowercase first letter of String.
     *      e.g. [foo, bar, few, boo, xyz] -> {f=[foo,few], b=[bar,boo], x=[xyz]}.
     * 4*. Like previous, but make resulting lists in ascending order and without duplicates.
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


    /**
     * Collect to List<Integer> all prime numbers between 1 and 1_000_000
     */
    private static void addToListPrimeNumbers() {
        List<Integer> integerList = new ArrayList<>();
        IntStream.rangeClosed(1, 1_000_000)
                .filter(x -> isPrime(x))
                .forEach(x -> integerList.add(x));
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
        List<Integer> randomInts = new ArrayList<>();
        random.ints()
                .limit(10)
                .forEach(x -> randomInts.add(x));
        List<Integer> sortedListDESC = randomInts.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedListDESC);
    }

    /**
     * Using random generator print to console all numbers in DESCENDING of its absolute value.
     */
    private static void printRandomNumbersDESCAbsoluteValues() {
        Random random = new Random();
        List<Integer> randomInts = new ArrayList<>();
        random.ints()
                .limit(10)
                .forEach(x -> randomInts.add(x));
        System.out.println(randomInts);
//        List<Integer> randomInts = new ArrayList<>((Arrays.asList(1,2,-5,0,4,3,-20)));
        List<Integer> sortedListDESC = randomInts.stream()
//                .sorted(Comparator.comparingInt(Math::abs).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedListDESC);
    }       // Problem here

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
        List<String> stringList = new ArrayList<>(List.of("foo", "foo", "bar", "few", "boo", "xyz"));
        List<String> distinctList = stringList.stream()
                .distinct()
                .collect(Collectors.toList());

        Map<Character, List<String>> characterListMap = distinctList.stream()
                .collect(Collectors.groupingBy(d -> d.toLowerCase().charAt(0)));
        System.out.println(characterListMap);

        LinkedHashMap<Character, List<String>> sortedMap = new LinkedHashMap<>();
        characterListMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        System.out.println(sortedMap);
    }   // ok?

}
