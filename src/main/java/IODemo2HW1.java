import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class IODemo2HW1 {
    //private static final String IN = "D:\\Text.txt";
    //private static final String OUT = "D:\\Bytes.txt";
    public static void main(String[] args) throws Exception{
        String text = "Hello world!";                    // для тестирования метод getBytes()
        try(FileOutputStream write =new FileOutputStream("D:\\Bytes.txt"))
        {
            byte[] buffer = text.getBytes();
            write.write(buffer, 0, buffer.length);   // почему метод записывает символ в файл, а не байт? при выводе в консоль там байты.
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }





        /*File file = new File("D:\\Text.txt");                 // found in Google
        byte[] bytes = new byte[(int) file.length()];
        try(FileInputStream reader = new FileInputStream(file)){
            reader.read(bytes);
        }
        //System.out.println(Arrays.toString(bytes));
        try(FileWriter writer = new FileWriter("D:\\Bytes.txt",StandardCharsets.US_ASCII)) {
            for (int i = 0; i < bytes.length; i++) {
                writer.write(bytes[i]);
            }
        }*/

        //run(OUT, IN);



        /*File file = new File("D:\\Text.txt");
        long size = countFileSize(file);
        byte[] b = copyBytesFromFile(file,(int)size);
        System.out.println(Arrays.toString(b));

        try(FileWriter writer = new FileWriter("D:\\Bytes.txt")) {
            for (int i = 0; i < b.length; i++) {
                writer.write(b[i]);
            }
        }*/

       /* try(FileWriter writer = new FileWriter("D:\\Bytes.txt",)) {
            for (int i = 0; i < b.length; i++) {
                writer.write(b[i]);
            }
        }*/
      /*int x;
        while ((x = reader.read() ) != -1) {
            System.out.println((char) x);
        }*/

    /*private static void run(String sourcePath, String destPath) {
        try (Scanner reader = new Scanner(new File(sourcePath));
             FileWriter writer = new FileWriter(destPath)) {
            int sum = 0;
            while (reader.hasNextInt()) {
                sum += reader.nextInt();
            }
            writer.write("sum: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static long countFileSize(File name) throws IOException {
        long numOfBytes = 0;
        try (FileInputStream file = new FileInputStream(name)) {
            int i = file.read();
            while (i != -1) {
                numOfBytes++;
                i = file.read();
            }
            return numOfBytes;
        }
    }

    public static byte[] copyBytesFromFile(File name, int numOfBytes) throws IOException {
        try (FileInputStream file = new FileInputStream(name)) {
            byte[] buffer = new byte[numOfBytes];
            file.read(buffer);
            return buffer;
        }
    }

    /*public static long countFileSize(String name) throws IOException {
        long numOfBytes = 0;
        try (FileReader file = new FileReader(name)) {
            int i = file.read();
            while (i != -1) {
                numOfBytes++;
                i = file.read();
            }
            return numOfBytes;
        }
    }*/

    /*public static byte[] copyBytesFromFile(FileReader name, int numOfBytes) throws IOException {
        try (Scanner scanner = new Scanner(name)) {
            String[] buffer = new String[numOfBytes];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = scanner.nextLine();
            }
            return buffer;
       }
    }*/

}


