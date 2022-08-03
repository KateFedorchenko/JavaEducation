package java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;

public class StreamDemo2 {
    @AllArgsConstructor
    static class Person {
        String name;
        LocalDate birthday;
    }

    public static void main(String[] args) {
        //-> Map<String,LocalDate>
        Map<String, LocalDate> collect = Stream.of(
                new Person("Ivan", LocalDate.parse("1990-01-01")),
                new Person("Sergey", LocalDate.parse("1993-02-01")),
                new Person("Vasya", LocalDate.parse("1990-01-03")),
                new Person("Pavel", LocalDate.parse("1992-01-31")),
                new Person("Alexander", LocalDate.parse("1980-11-01")),
                new Person("Peter", LocalDate.parse("1999-10-01"))
            )//Stream<Person>
            .collect(Collectors.toMap(/*keyMapper*/p -> p.name, /*valueMapper*/p -> p.birthday));

        System.out.println(collect);

    }

    public static void collectorToList() {
        List<Long> collect = ThreadLocalRandom.current()
            .longs(1000)
            .boxed()
            .filter(x -> x > 0)
            .collect(Collectors.toList());

        System.out.println(collect);

        CopyOnWriteArrayList<Long> collect2 = ThreadLocalRandom.current()
            .longs(1000)
            .boxed()
            .filter(x -> x > 0)
            .collect(Collectors.toCollection(() -> new CopyOnWriteArrayList<>()));

        System.out.println(collect2);

    }

    public static void parallelStreams() {
        int SIZE = 1_000_000_000;
        double[] arr = new double[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = ThreadLocalRandom.current().nextDouble(0, 1_000_000);
        }

        Runnable r1 = () -> Arrays.stream(arr).sum();
        Runnable r2 = () -> Arrays.stream(arr).parallel().sum();

        measureTime(r1);
        measureTime(r2);
    }

    public static void measureTime(Runnable r) {
        long start = System.currentTimeMillis();
        r.run();
        System.out.println("Measured time: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void otherIntermediateOps() throws Exception {
        long count = Stream.of("foo", "bar", "qwe")
            .filter(x -> true)
            .peek(System.out::println)
            .count();

        Stream.of("foo", "bar", "qwe", "foo", "Foo", "Bar", "QWE", "foo")
            .distinct()
            .forEach(System.out::println);

        Stream.of("foo", "far", "bar", "qwe", "foo", "Foo", "Bar", "QWE", "foo")
//            .filter(x -> x.charAt(0) != 'f')
//            .dropWhile(x -> x.charAt(0) == 'f')
            .dropWhile(StreamDemo2::firstSymbolIsF)
            .forEach(System.out::println);

        Stream.of("foo", "bar", "qwe", "foo", "Foo", "Bar", "QWE", "foo")
            .skip(3)
            .forEach(System.out::println);

        Stream.of("foo", "bar", "qwe", "foo", "Foo", "Bar", "QWE", "foo")
            .sorted()
            .forEach(System.out::println);

        Stream.of("foo", "bar", "qwe", "foo", "Foo", "Bar", "QWE", "foo")
            .takeWhile(s -> s.charAt(0) >= 'a' && s.charAt(0) <= 'z')
            .forEach(System.out::println);
    }

    public static boolean firstSymbolIsF(String s) {
        return s.charAt(0) == 'f';
    }

    public static void otherWaysToCreateStreams() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};

        //Stream<T> Generic reference type stream
        //IntStream
        //LongStream
        //DoubleStream
        Arrays.stream(arr);//IntStream
        Arrays.stream(arr).boxed();//Stream<Integer>

        System.out.println(
            "Stream.of(arr).count() = " + Stream.of(arr).count()
        );//not Stream<Integer> but Stream<int[]>

        Random random = new Random();

        random.doubles();//DoubleStream;
        random.ints();//IntStream;
        random.longs();//LongStream;

        List<String> strings = new ArrayList<>();
        random.longs()//LongStream
            .limit(1000)
            .mapToObj(l -> String.valueOf(l))//Stream<String>
            .forEach(s -> strings.add(s));

//        System.out.println(strings);

        Files.lines(Path.of("c:", "misc", "text.txt"))//c:\misc\text.txt
            .forEach(System.out::println);
    }
}


// 1) Random nums