package beginner;

import java.io.*;
import java.util.Scanner;

public class IODemo2HW1 {
    public static void main(String[] args) throws Exception {
        try(FileReader reader = new FileReader("D:\\Text.txt");
            FileWriter writer = new FileWriter("D:\\Bytes.txt")){
            int x;
            while ((x = reader.read()) != -1) {
                writer.write(Integer.toString(x,16));
                writer.write(" ");
            }
        }
    }

    public static void copyTextToBytes() throws  Exception {
        try(Scanner scanner = new Scanner(new FileReader("D:\\Bytes.txt"));
            FileWriter writer = new FileWriter("D:\\BytesOut.txt"))
        {
            while(scanner.hasNextByte()) {
                writer.write((char) scanner.nextByte());
            }
        }
    }
}


