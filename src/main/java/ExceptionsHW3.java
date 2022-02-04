import java.util.Random;
import java.util.Scanner;

public class ExceptionsHW3 {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNumber = r.nextInt(100);

        Scanner scanner = new Scanner(System.in);
        int numOfTries = 10;
        for (int i = 0; i < numOfTries; i++) {
            int num = scanner.nextInt();
            if(num == randomNumber) {
                System.out.println("You won!");
                return;
            }
            if(num > 99 || num < 0) {
                throw new BusinessException("Your number is out of possible range");
            }
            System.out.println("Try one more time!");
        }
        System.out.println("Sorry, the game is over.");
    }

    static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
        }
    }
}
