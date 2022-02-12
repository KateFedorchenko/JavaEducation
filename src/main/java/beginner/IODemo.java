package beginner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
       try (FileInputStream i = new FileInputStream("text.txt")) {
           int x;
           while((x = i.read()) != -1) {
               System.out.println((char)x);
           }
       }
    }

    public static void java6ResourceManager() throws IOException {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("data.txt");
            f.write(59);
            System.out.println(1/0);
        } catch (RuntimeException e) {
            throw e;
        } finally {
            f.close();
        }
    }

    public static void java7ResourceManager() throws IOException{
        try(FileOutputStream f = new FileOutputStream("data.txt");
            FileOutputStream x = new FileOutputStream("foo.txt");
        ) {
            f.write(59);
            x.write(100);

        }
    }
}


// 1) создать два файла. один заполнить данными (текст). второй должен скопировтаь данные из первого
// 2) создать 3-4 файла с данными. скопировать содержимое всех файлов в один из них
// 3) скопировать из одного файла в другой с обратным порядком байтов (подумать) - написать насчет плана.