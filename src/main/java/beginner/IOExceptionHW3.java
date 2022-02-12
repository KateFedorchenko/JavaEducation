package beginner;

import java.io.*;

public class IOExceptionHW3 {
    public static void main(String[] args) throws IOException {
        File reader = new File("D:\\HW3_file2.txt");

        long size = countFileSize(reader);
        byte[] arr = copyBytesFromFile(reader,(int) size);

        try(FileOutputStream writer = new FileOutputStream("D:\\HW3_file1.txt")) {
            for (int i = arr.length -1; i >= 0; i--) {
                writer.write(arr[i]);
            }
        }
    }

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
}
