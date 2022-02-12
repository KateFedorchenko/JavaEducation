package beginner;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionsHW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert ten numbers below: ");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int num = scanner.nextInt();
            arr[i] = num;
        }
        System.out.println("Your numbers are: "+ Arrays.toString(arr));
        System.out.println("Please, insert any index you want to see in array: ");
        int index = scanner.nextInt();
        try {
            System.out.println("Your number is "+arr[index]);
        } catch (IndexOutOfBoundsException e){
            System.out.println("This index is out of bound.");
        }
    }
}
