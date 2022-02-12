package beginner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExceptionHW2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream sourceFileWriter = new FileOutputStream("D:\\HW2_sourceFile.txt",true);

        FileInputStream file2Reader = new FileInputStream("D:\\HW2_file2.txt");   // чтение файл2
        FileInputStream file3Reader = new FileInputStream("D:\\HW2_file3.txt");   // чтение файл3

        copyText(file2Reader,sourceFileWriter);
        copyText(file3Reader,sourceFileWriter);
    }

    public static void copyText(FileInputStream i, FileOutputStream sourceFile) throws IOException {
        sourceFile.write('\n');
        int j = i.read();
        while(j!= -1){
            sourceFile.write(j);
            j = i.read();
        }
    }
}

// Task: создать 3-4 файла с данными. скопировать содержимое всех файлов в один из них

