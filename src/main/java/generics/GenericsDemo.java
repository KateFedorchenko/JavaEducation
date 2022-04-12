package generics;

import java.math.BigDecimal;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3);
        System.out.println("sumAll(list) = " + sumAll(list));
        List<Double> doubles = List.of(0.1,2.76,2.0);
        System.out.println("sumAll(doubles) = " + sumAll(doubles));
    }

    public static <T extends Number> double sumAll(List<T> list){
        double sum = 0;
        for (T num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void covariantVersusContrVariant(){
        Integer e = 22;
        Integer[] ints = {1,2,3};
        Number n = e;
        Number[] nums = ints;                            // works with arrays

        nums[0] = new BigDecimal("1000");           // ArrayStoreException because of {"1000",2,3}

        List<Integer> list = List.of(1,2,3);
        //List<Number> listOfNums = list;               // does not work with generics
    }

    public static void printStringSize(Optional<String> str) {
        if (str.isEmpty()) {
            System.out.println("You did not provide String");
        } else {
            System.out.println("String size is " + str.get().length());
        }
    }

    public static void optional() {
        Optional<String> optEmpty = new Optional<>(null);         // Optional class
        Optional<String> optNotEmpty = new Optional<>("java");
        Optional<List<String>> optList = new Optional<List<String>>(List.of("boo", "foo"));

        printStringSize(optEmpty);
    }

}

// написать алгоритм сортировки (любой) для строк (через CompareTo()) и полученный алгоритм переписать на других типах (<T extends Comparable<T>>).
// Проверить на классе Integer, LocalDate (LocalDate.of()). Можно на них сравнить.

// register LeeTCode. --> tasks there --> Algorithms --> level Easy-Medium --> tags "Arrays or Strings" --> choose any one task and try to cope with it
// solution to be written here
// one task per one week for now --> any questions to Telegram -- tell what task I have taken