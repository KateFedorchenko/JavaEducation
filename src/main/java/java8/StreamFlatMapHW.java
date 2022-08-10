package java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMapHW {
    public static void main(String[] args) {
        getDates();


    }


    /**
     * Given array of LocalDates convert it to stream of all unique dates which within two days.
     * [2022-01-01, 2022-03-08]->[2021-12-30, 2021-12-31, 2022-01-01, 2022-01-02, 2022-01-03, 2022-03-06, 2022-03-07, 2022-03-08, 2022-03-09
     */

    private static void getDates(){
        List<LocalDate> localDateList = List.of(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 3, 8));
        Stream<List<LocalDate>> stream = localDateList.stream()
                .map(x -> getDatesWithinTwoDays(x));
        System.out.println(stream.toList());
    }

    public static List<LocalDate> getDatesWithinTwoDays(LocalDate startDate) {
        List<LocalDate> after = startDate
                .datesUntil(startDate.plusDays(2))
                .collect(Collectors.toList());

        List<LocalDate> before = startDate
                .datesUntil(startDate.minusDays(2))
                .collect(Collectors.toList());

        List<LocalDate> result = new ArrayList<>();
        result.addAll(before);
        result.addAll(after);
        return result;
    }

    /**
     * Given array of ints, a) find average value
     */
    private static void findAvgWithReduce() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7};
        IntStream stream = Arrays.stream(numbers);
        int sum = stream.reduce(0, Integer::sum);
        System.out.println(sum / numbers.length);
//      OptionalDouble avg = IntStream.of(sum)
//                .average();

    }

    private static void findAvgWOReduce() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
        System.out.println(avg);
    }


    /**
     * Convert stream of numbers to array/list of DIGITS (145,143,3,11) -> [1,4,5,1,4,3,3,1,1].
     */
    private static void convertStreamNumsToListDigits() {
        Stream<Integer> integerList = Stream.of(145, 143, 3, 11);
        List<Integer> collect = integerList.flatMap(d -> convertToDigits(d))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static Stream<Integer> convertToDigits(int num) {
        String str = String.valueOf(num);
        char[] charDigits = str.toCharArray();
        int[] nums = new int[charDigits.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Character.digit(charDigits[i], 10);
        }
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            intList.add(Integer.valueOf(nums[i]));
        }
        return intList.stream();
    }


}
