package java8;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDemoHW {
    public static void main(String[] args) {
        /**
         * To convert a list of Integers into list of HEXADECIMAL Strings,
         * then to filter it by choosing the first String element starting at 0 - 9,
         * then print it.
         */
        List<Integer> list = List.of(43343, 55112, 2356003, 160114, 5035, 856);
        ArrayList<String> listArr = new ArrayList<>();
        list.stream()
                .forEach(x -> listArr.add(Integer.toHexString(x)));
        listArr.stream()
                .filter(x -> x.startsWith("0") || x.startsWith("1") || x.startsWith("2")
                        || x.startsWith("3") || x.startsWith("4") || x.startsWith("5")
                        || x.startsWith("6") || x.startsWith("7") || x.startsWith("8") || x.startsWith("9"))
                .forEach(System.out::println);

        /**
         * There's a list of LocalDates.
         * How many of them are on weekends to be counted.
         */
        List<LocalDate> localDates = List.of(LocalDate.of(2022, 9, 18),
                LocalDate.of(2022, 7, 30), LocalDate.of(2022, 8, 2),
                LocalDate.of(1970, 1, 1), LocalDate.of(2022, 5, 15));
        long count = localDates.stream()
                .filter(localDate -> localDate.get(ChronoField.DAY_OF_WEEK) == 6 ||
                        localDate.get(ChronoField.DAY_OF_WEEK) == 7)
                .count();
        System.out.println(count);

        /**
         * To sum all even numbers from 1 to 1_000_000.
         * Доп задание:
         * Нужно посчитать сумму всех четных чисел от 1 до 1_000_000.
         * Для создания соответствующего стрима используй IntStream.rangeClosed(int, int).
         * Обрати внимания, что у IntStream  есть доп терминальные методы
         */
        long sum = IntStream.range(1, 1_000_000)
                .filter(x -> x % 2 == 0)
                .sum();
        System.out.println(sum);

    }
}
