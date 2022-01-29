import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) throws IOException {
        Object o = null;
        System.out.println(o.hashCode());
        System.in.read();

    }

    public static void catchingException(){
        System.out.println("A");
        try {
            System.out.println("B");
            FileInputStream f = new FileInputStream("D:\\tet.txt");
            System.out.println("C");
        } catch (FileNotFoundException e) {
            System.out.println("Not found");
            e.printStackTrace();
        }
        System.out.println("D");
    }

    public static void catchingExceptions2(){
        int x = 0;
        int[] arr = new int[10];
        try {
            System.out.println(10 / x);
            System.out.println(arr[10]);
        } catch (ArithmeticException|IndexOutOfBoundsException e){
            System.out.println("compute error");
        } catch (RuntimeException e) {
            System.out.println("not permitted");
        }
    }

}



// 1) с помощью Scanner (new Scanner(System.in)) получить экземпляр -> программа должна запросить int ( 2 числа) и посчитать деление и вывести юзеру
// Обработать деление на 0.
// 2) с помощью Scanner запросить 10 чисел - записать числа в массив - запросить у юзера индекс и вывести значение по этому индексу в консоль. Обработаь с IndexOutOfBoundsException
// 3) с помощью FileWriter и FileReader содержимое одного файла скопировать в другой файл.