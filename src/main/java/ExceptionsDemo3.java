public class ExceptionsDemo3 {
    static String[] data = {"a","b","s","f"};
    public static void main(String[] args) {
        System.out.println(accessData(4));
    }

    public static String accessData(int x) {
        String text = "Your text is ";
        try{
            return text + data[x];
        } catch (RuntimeException e) {
            throw new BusinessException("Error while accessing data with x = " + x, e);
        }
    }

    static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
        }

        public BusinessException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
// Scanner --> создавать экзмепляр класса Random r = new Random(); У него есть метод r.nextInt(100). Дает случайное число от 0 от 99.
// с помощью Scanner даем угадать число. напр бинарный поиск. если попытки исчерапны то дает сообщение - завершаем программу без ислк. Исключение нужно: 1)если человек назовет число больше диапазона


// модификация . если человек назовет число которое ранее называл ИЛИ неправильно воспользовался подсказкой (больше или меньше) даем искл.