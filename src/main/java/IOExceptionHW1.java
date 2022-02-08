import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOExceptionHW1 {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);    // запись в файл1
        FileInputStream fileInputStream = new FileInputStream(file);       // чтение файл1
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
                "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                "mollit anim id est laborum.";
        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();


        File file2 = new File("D:\\CopyOfTest.txt");
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);  // запись в файл2
        int i = fileInputStream.read();                                    // чтение файл1
        while(i!= -1){
            fileOutputStream2.write(i);
            i = fileInputStream.read();
        }
    }
}


// 1) создать два файла. один заполнить данными (текст). второй должен скопировтаь данные из первого