import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOExceptionHW3 {
    public static void main(String[] args) throws IOException {
        FileInputStream file1Reader = new FileInputStream("D:\\HW3_file1.txt");         // чтение файл1
        FileOutputStream file2Writer= new FileOutputStream("D:\\HW3_file2.txt");        // запись в файл2

        int numOfBytes = 0;
        int i = file1Reader.read();
        while(i!= -1){
            numOfBytes++;
            i = file1Reader.read();
        }

        int s = file1Reader.read(); // why the val is -1?

        int[] buffer = new int[numOfBytes];
        for (int j = 0; j < buffer.length; j++) {
            buffer[j] = s;
            s = file1Reader.read();
        }
    }
}


/* Questions:
1) Не до конца понимаю, как работает итератор символов в цикле while. Почему происходит перебор символов, если я не указываю
это?
2) Новая переменная s начинается не с начала файла, а присваивает последнее присвоенное значение i (= -1). Почему?

Мой план:
1) узнать кол-во символов
2) в массив скопировать эти символы
3) в обратном значения перекопировать символы в другой файл
*/