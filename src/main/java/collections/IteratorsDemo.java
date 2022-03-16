package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IteratorsDemo {
    public static void main(String[] args) {
        Iterable<String> collection = new HashSet<>(List.of("fd","fs","fed","fws","qwq","we"));
        for (String s : collection) {
       }
        for (Iterator<String> it = collection.iterator(); it.hasNext();){  // is equal to the cycle above
            String s = it.next();
        }
    }

    public static void readWithIterators() {
        Iterable<String> strs = List.of("foo", "bar", "qwe");
        Iterator<String> it = strs.iterator();   // to iterate through collection from start to end

        while (it.hasNext()) {                                                // 'it' is visible everywhere    -- bad
            System.out.println(it.next());
        }

        Iterable<String> collection = List.of("jkk", "dd", "dw");
        for (Iterator<String> i = collection.iterator(); i.hasNext(); ) {      // better
            System.out.println(i.next());
        }
    }
    public static void correctRemovingFromArrayList(){
        Iterable<String> collection = new ArrayList<>(List.of("boo", "fpp", "dd", "fef", "fe", "ww"));

        for (Iterator<String> it = collection.iterator(); it.hasNext(); ) {
            String str = it.next();
            if (str.length() == 2) {
                it.remove();
            }
        }
        System.out.println(collection);
    }
    public static void incorrectRemovingFromArrayList(){
        List<String> collection = new ArrayList<>(List.of("boo", "fpp", "dd", "fef", "fe", "ww","qq"));

        for (int i = 0; i < collection.size(); i++) {
            if(collection.get(i).length() == 2){
                collection.remove(i);
            }
        }             // incorrect cycle
        System.out.println(collection);
    }
    public static void correctRemovingFromArrayListButUgly(){
        List<String> collection = new ArrayList<>(List.of("boo", "fpp", "dd", "fef", "fe", "ww","qq"));

        for (int i = collection.size()-1; i >= 0; i--) {
            if(collection.get(i).length() == 2){
                collection.remove(i);
            }
        }                                                             // correct cycle
        System.out.println(collection);


    }
}


// 1) Анализ текста программа. Ф-ия принимает одну строку. кот-ая содержит текст. Текст - набор из слов и пробелов. Слово - строка из больших и мал латинских букв и цифр.
// Нужно вывести в консоль суммарное кол-во слов и суммарное кол-во уникальных слов и кол-во уникальных слов без учета регистра. Есть тесты на задачу.