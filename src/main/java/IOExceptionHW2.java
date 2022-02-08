import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExceptionHW2 {
    public static void main(String[] args) throws Exception {
        File file1 = new File("D:\\file1.txt");
        File file2 = new File("D:\\file2.txt");
        File file3 = new File("D:\\file3.txt");

        FileOutputStream writer = new FileOutputStream(file1,true);
        String text1 = "С другой стороны начало повседневной работы по формированию позиции требуют от нас анализа соответствующий условий активизации. Товарищи! дальнейшее развитие различных форм деятельности обеспечивает широкому кругу (специалистов) участие в формировании соответствующий условий активизации.";
        writer.write(text1.getBytes());
        //writer.close();

        FileOutputStream writer2 = new FileOutputStream(file2);
        String text2 = "Равным образом рамки и место обучения кадров представляет собой интересный эксперимент проверки существенных финансовых и административных условий. Не следует, однако забывать, что укрепление и развитие структуры требуют определения и уточнения новых предложений. Значимость этих проблем настолько очевидна, что рамки и место обучения кадров позволяет выполнять важные задания по разработке позиций, занимаемых участниками в отношении поставленных задач.";
        writer2.write(text2.getBytes());
        //writer2.close();


        FileOutputStream writer3 = new FileOutputStream(file3);
        String text3 = "Задача организации, в особенности же постоянный количественный рост и сфера нашей активности требуют определения и уточнения систем массового участия. Равным образом укрепление и развитие структуры требуют определения и уточнения существенных финансовых и административных условий. ";
        writer3.write(text3.getBytes());


        FileInputStream reader2 = new FileInputStream(file2);   // чтение файл2
        FileInputStream reader3 = new FileInputStream(file3);   // чтение файл3

        copyText(reader2,writer,writer2);
        copyText(reader3,writer,writer3);
    }

    public static void copyText(FileInputStream i, FileOutputStream sourceFile, FileOutputStream closeFile) throws IOException {
        int j = i.read();
        while(j!= -1){
            sourceFile.write(j);
            j = i.read();
        }
        closeFile.close();
    }
}


// 2) создать 3-4 файла с данными. скопировать содержимое всех файлов в один из них