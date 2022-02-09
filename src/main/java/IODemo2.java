import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("D:\\HW1_file1.txt", StandardCharsets.UTF_16);
        int x;
        while ((x = reader.read() ) != -1) {
            System.out.println((char) x);
        }
    }
}

// 1) есть файл 'Bytes'. В нем через пробел перечислены байты в десятичном виде. С помощью Scanner прочесть все байты
// и записать в другой файл не в виде байтов а в виде символов. Пример, есть файл 'df.txt' с телом '72 69 76 76 79'.
// Моя программа должна открыть файл и перезаписать в другой файл этот текст словами HELLO.

// Тестирвоать на чем-то сложнее

// 2) Обратная задача. с норм текстом. надо норм текст переделать в файл где будут байты разделены пробелом. С UTF-8 на другой - русский тексит
// 2)* Эти байты вывести в 16-и виде.