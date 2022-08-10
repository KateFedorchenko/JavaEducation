package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
1. Convert stream of number to array/list of DIGITS (145, 143, 3, 11) -> [1,4,5,1,4,3,3,1,1]
2. Given array of LocalDates convert it to stream of all unique dates which within two days.
    [2022-01-01, 2022-03-08]->[2021-12-30, 2021-12-31, 2022-01-01, 2022-01-02, 2022-01-03, 2022-03-06, 2022-03-07, 2022-03-08, 2022-03-09, 2022-03-10]
3. Given array of ints, a)find average value, b) Standard deviation.

*** download jetty webserver
 */
public class StreamFlatMapDemo {

    public static void main(String[] args) {
        List<String> reduced = Stream.of("foo", "bar", "qwe", "xyz")
            .reduce(new ArrayList<>(), (List<String> list, String el) -> {
                list.add(el);
                return list;
            }, (l1, l2) -> {
//                throw new RuntimeException();
                l1.addAll(l2);
                return l1;
            });

        System.out.println(reduced);

    }

    private static void reducerAsACollector() {

    }

    private static void reducerAsComplexProcess() {
        List<String> l = List.of(
            "foo",
            "xyz",
            "zoo",
            "bar",
            "bzz"
        );//->bao

        String reduced = l.stream()
            .reduce("zzz", StreamFlatMapDemo::getMin);

        System.out.println(reduced);
    }

    private static String getMin(String state, String el) {
        System.err.println("State = " + state + " el = " + el);
        assert state.length() == el.length();
        char[] res = new char[state.length()];

        for (int i = 0; i < res.length; i++) {
            res[i] = (char) Math.min(state.charAt(i), el.charAt(i));
        }
        return new String(res);
    }

    private static void primitiveReducer() {
        List<Integer> collect = Stream.of(1, 2, 3, 4)
            .collect(Collectors.toList());// reduce

        int sum = Stream.of(1, 2, 3, 4, 5)
            .mapToInt(i -> i)//IntStream
            .sum();// reduce



        int reducedSum = IntStream.rangeClosed(1, 100)//100 * 101/2 = 5050
            .reduce(0, (a, b) -> a + b);//IntBinaryOperator === BiFunction<int, int, int>

        System.out.println(reducedSum);

        int reducedMultiplication = IntStream.rangeClosed(1, 10)
            .reduce(1, (a, b) -> a * b);

        System.out.println(reducedMultiplication);
    }

    private static Stream<Character> convertStringToStream(String s){
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            characterList.add(s.charAt(i));
        }
        return characterList.stream();
    }

    public static void flatMap1() {
        List<List<String>> ll = List.of(
            List.of("foo", "bar"),
            List.of("xyz", "qwe"),
            List.of("test", "must")
        );

        Set<String> set = new HashSet<>();

        for (List<String> strings : ll) {
            for (String string : strings) {
                set.add(string);
            }
        }

        Set<String> set2 = ll.stream()
            .flatMap(l -> l.stream())
            .collect(Collectors.toSet());

        System.out.println(set.equals(set2));

        int[][][] arr = {
            {{1,2,3}, {9,8,7}, {6,6,7}},
            {{3,2,1}, {123,11}, {}},
            {{1,1,1}}
        };//-> List<Integer>

        List<Integer> list = Arrays.stream(arr)//Stream<int[][]>
            .flatMap((int[][] e) -> Arrays.stream(e))//Stream<int[]>
            .flatMapToInt((int[] e) -> Arrays.stream(e))//IntStream
            .boxed()//Stream<Integer>
            .collect(Collectors.toList());

        System.out.println(list);

        List<String> strings = List.of("Ivan", "Maria", "Sergey", "Peter", "Alexander"); //-> List<Character>
        List<Character> res = strings.stream()
            .flatMapToInt(String::chars)
            .mapToObj(i -> (char) i)
            .collect(Collectors.toList());

        System.out.println(res);
    }

}
