import java.util.Random;
import java.util.Scanner;

public class ExceptionsHW3 {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNumber = r.nextInt(100);

        Scanner scanner = new Scanner(System.in);
        int numOfAttempts = 10;
        for (int i = 0; i < numOfAttempts; i++) {
            int num = scanner.nextInt();
            if(num == randomNumber) {
                System.out.println("You won!");
                return;
            }
            if(num > 99 || num < 0) {
                throw new BusinessException("Your number is out of possible range");
            }
            if(num > randomNumber) {
                System.out.println("The secret number is lesser than current iteration attempt.");
            } else {
                System.out.println("The secret number is bigger than current iteration attempt.");
            };
        }
        System.out.println("Sorry, the game is over.");
    }

    static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
        }
    }
}
