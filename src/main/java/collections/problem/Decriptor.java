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
    private Map<Character,Character> dictionary;       // called objective approach -- better -- too many 'static' word is bad

    public Decriptor(Map<Character, Character> dictionary) {
        this.dictionary = dictionary;
    }

    public static void main(String[] args){
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 25; i++) {
            if (i == 24) {
                map.put('a', 'z');
            }
            map.put((char) ('b' + i), (char) ('a' + i));
        }
        map.put(' ', ' ');
        map.put('.', '.');
        map.put(',', ',');
        String str = "jo dpnqvujoh, b ibti ubcmf jt b ebub tusvduvsf uibu jnqmfnfout bo bttpdjbujwf bssbz bctusbdu ebub uzqf, b tusvduvsf uibu dbo nbq lfzt up wbmvft.";

        Decriptor decriptor = new Decriptor(map);
        System.out.println(decriptor.decrypt(str));
    }

    public String decrypt(String str){
        char[] chars = str.toCharArray();                     // standard method -- toCharArray() -- better to use
        for(int i = 0; i < chars.length; i++) {
            if (!dictionary.containsKey(chars[i])) {
                throw new RuntimeException("Your string cannot be decrypted - no such character for key has been found");
            }
        }
        char[] objectArray = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            objectArray[i] = dictionary.get(chars[i]);
        }
        return new String(objectArray);
    }

}

