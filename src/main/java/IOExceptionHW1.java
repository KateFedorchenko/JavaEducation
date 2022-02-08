import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOExceptionHW1 {
    public static void main(String[] args) throws Exception {
        FileInputStream file1Reader = new FileInputStream("D:\\HW1_file1.txt");         // чтение файл1
        FileOutputStream file2Writer= new FileOutputStream("D:\\HW1_file2.txt");        // запись в файл2
        int i = file1Reader.read();
        while(i!= -1){
            file2Writer.write(i);
            i = file1Reader.read();
        }
    }
}

// 1) создать два файла. один заполнить данными (текст). второй должен скопировтаь данные из первого