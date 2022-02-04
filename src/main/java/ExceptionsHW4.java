import java.util.Random;
import java.util.Scanner;

public class ExceptionsHW4 {
        public static void main(String[] args) {
            Random r = new Random();
            int randomNumber = r.nextInt(100);

            Scanner scanner = new Scanner(System.in);
            int numOfAttempts = 10;
            int[] arrOfNums = new int[10];
            for (int i = 0; i < numOfAttempts; i++) {
                int num = scanner.nextInt();
                if(num == randomNumber) {
                    System.out.println("You won!");
                    return;
                }
                if(num > 99 || num < 0) {
                    throw new BusinessException("Your number is out of possible range");
                }
                if(i > 0) {
                    for (int j = 0; j < arrOfNums.length; j++) {
                        if(arrOfNums[j] == num) {
                            throw new BusinessException("The same number appears twice.");
                        }
                    }
                    if(arrOfNums[i-1] > randomNumber) {
                        if(num > arrOfNums[i-1]) {
                            throw new BusinessException("Bad luck! You have inserted the number bigger than the previous one.");
                        }
                    } else {
                        if(num < arrOfNums[i-1]) {
                            throw new BusinessException("Bad luck! You have inserted the number lesser than the previous one.");
                        }
                    }
                }
                if(num > randomNumber) {
                    System.out.println("The secret number is lesser than current iteration attempt.");
                } else {
                    System.out.println("The secret number is bigger than current iteration attempt.");
                }
                arrOfNums[i] = num;
            }
            System.out.println("Sorry, the game is over.");
        }

        static class BusinessException extends RuntimeException {
            public BusinessException(String message) {
                super(message);
            }
        }
    }

// Scanner --> создавать экзмепляр класса Random r = new Random(); У него есть метод r.nextInt(100). Дает случайное число от 0 от 99.
// с помощью Scanner даем угадать число. если попытки исчерапны, то дает сообщение - завершаем программу без ислк. Исключение нужно: 1)если человек назовет число больше диапазона


// модификация . если человек назовет число, которое ранее называл ИЛИ неправильно воспользовался подсказкой (больше или меньше) - даем искл.