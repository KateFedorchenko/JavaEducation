package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamDemo1 {
    public static boolean isWorkingTime(LocalTime time) {
        if (time.getHour() >= 9 && time.getHour() < 18) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 5, 7, 9, 66);
        long count = list.stream()
                .filter(x -> x % 3 == 0)
                .count();
        System.out.println(count);
        Integer max = list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("empty list was not expected"));
    }


    public void streamFilter() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
//        list.stream().forEach(x -> System.out.println(x));

        ArrayList<Integer> listArr = new ArrayList<>();
        list.stream()
                .filter(x -> x % 2 != 0)
                .forEach(listArr::add);
        System.out.println(listArr);
    }

    public void streamFilterMap() {
        List<LocalTime> list = List.of(
                LocalTime.of(2, 34),
                LocalTime.of(5, 55),
                LocalTime.of(15, 4),
                LocalTime.of(18, 35),
                LocalTime.of(17, 35),
                LocalTime.of(9, 5),
                LocalTime.of(23, 55)
        );
        list.stream()
                .filter(StreamDemo1::isWorkingTime)
                .map(x -> LocalDateTime.of(LocalDate.now(), x))
                .forEach(System.out::println);
    }
}


