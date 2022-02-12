package beginner;

import java.util.Scanner;

public class ExceptionsHW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert two POSITIVE numbers below: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        if(number1>=0 && number2>=0) {
            if(number2 == 0) {
                System.out.println("Are you sure the second number to be 0? If yes - print 'y' or 'yes'!");
                String str = scanner.next();
                if(str.equals("y") || str.equals("yes")){

                } else {
                    System.out.println("Ok. Insert another numbers one more time!");
                    return;
                }
            }
            System.out.println("Thank you! You have inserted two numbers " + number1 + " и "+ number2);
            System.out.println("The numbers are going to be divided: ");
            divideNumbers(number1,number2);
        } else {
            System.out.println("Negative numbers are not accepted here. Try one more time!");
        }
    }

    public static void divideNumbers(int num1, int num2) {
        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Compute error. It was a mistake to put 0 for the second number!");
        }
    }
}
