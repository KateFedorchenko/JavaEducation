package collections.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * При инициализации декриптора передается таблица дешифрования - map с шифром. Map имеет тип : Map<Character,Character>.
 * Реализовать метод string decript(String str){}. Примеры для теста. Сделать тесты для метода.
 * return расшифрованный текст.
 */
public class Decriptor {
    public static void main(String[] args) throws Exception {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put((char) ('b' + i), (char) ('a' + i));
        }
        decrypt("kbwb",map);
    }

    public static String decrypt(String str, Map map) throws Exception{
        char[] chars = new char[str.length()];           // String to be converted to char array
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        for (int i = 0; i < chars.length; i++) {        // check if there is any char that cannot be decrypted
            if(map.containsKey(chars[i])){
            } else {
                throw new Exception("Your string cannot be decrypted - no such character for key has been found");
            }
        }

        Object[] objectArray = new Object[chars.length];
        for (int i = 0; i < chars.length; i++) {
            objectArray[i] = map.get(chars[i]);
        }

        return Arrays.toString(objectArray);         // toString(Obj[] o) should convert my Object array to a String --> but it does not- why?
    }


}
