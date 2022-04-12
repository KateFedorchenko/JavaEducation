package generics;
import java.util.Scanner;

import static generics.Month.*;

public class GenericsDemo2 {
    public static void main(String[] args) {
        Converter<String,SimpleDate> converter = new StringToSimpleDateConverter();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(converter.convert(str));
    }

    public void toStringConverterUsage(){
        ToStringConverter<Integer> intToStrConverter =  new ToStringConverter<>();
        String res = intToStrConverter.convert(2);
        System.out.println(res.length());

    }

}


// 1) task LeetCode
// 2) Свой Класс ForwardList --> он умеет: метод getFront()