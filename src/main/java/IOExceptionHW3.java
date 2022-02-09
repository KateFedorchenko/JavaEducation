import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.util.Arrays;

public class IOExceptionHW3 {
    public static void main(String[] args) throws IOException {
        int numOfBytes = 0;
        try (FileInputStream file1Reader = new FileInputStream("D:\\HW3_file1.txt");         // чтение файл1
            FileOutputStream file2Writer = new FileOutputStream("D:\\HW3_file2.txt"))
        {
            int i = file1Reader.read();
            while (i != -1) {
                numOfBytes++;
                i = file1Reader.read();
            }
           // file1Reader.close();
            if(numOfBytes == 0) {
                throw new BusinessException("The file is empty");
            }

            int s = file1Reader.read();
            int[] buffer = new int[numOfBytes];
            for (int j = 0; j < buffer.length; j++) {
                buffer[j] = s;
                s = file1Reader.read();
            }

            for (int k = buffer.length-1; k >= 0; k--) {
                int symbol = buffer[k];
                file2Writer.write(symbol);
            }
            System.out.println(Arrays.toString(buffer));
        }  catch (FileNotFoundException e) {
            throw new BusinessException("No file has not been found");
        }

    }

    static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
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