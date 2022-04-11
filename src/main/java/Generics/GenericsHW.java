package Generics;

import java.time.LocalDate;
import java.util.*;

public class GenericsHW {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("away", "all", "camel", "abnormal","sorry","soup"));
        System.out.println(sortStrings(list));

        List<Integer> nums = new ArrayList<>(List.of(2,3,22,9,0,-54,3300,5,-1));
        System.out.println(sortIntegers(nums));

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2013, 1, 1));
        dates.add(LocalDate.of(2010, 3, 1));
        dates.add(LocalDate.of(1999, 1, 1));
        dates.add(LocalDate.of(1600, 2, 1));
        dates.add(LocalDate.of(1600, 2, 2));
        System.out.println(sortDates(dates));
    }

    public static <T extends String> List<T> sortStrings(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
        return list;
    }

    public static <T extends Integer> List<T> sortIntegers(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
        return list;
    }

    public static <T extends LocalDate> List<T> sortDates(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
        return list;
    }
}



// написать алгоритм сортировки (любой) для строк (через CompareTo()) и полученный алгоритм переписать на других типах (<T extends Comparable<T>>).
// Проверить на классе Integer, LocalDate (LocalDate.of()). Можно на них сравнить.