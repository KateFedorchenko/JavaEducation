package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("foo", "bar", "tee"));
        strings.get(0);
        strings.set(0,"qwe");
        strings.remove(0);
    }

    public static void doSmth(String str) {}
    public static void arrList(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("foo");
        arr.add("bar");
        System.out.println(arr.get(0));
        doSmth(arr.get(0));

        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<Date> dates = new ArrayList<>();
    }
    public static void iterable(){
        Iterable<String> steps = new ArrayList<>(List.of("foo", "bar", "tee"));
        for(String str : steps) {
            System.out.println(str);
        }
    }
    public static void collection(){
        Collection<String> collection = new ArrayList<>();
        collection.size();
        collection.add("foo");
        collection.remove("bar");
        collection.contains("foo");  // true
        collection.clear();
    }
}


// 1) Любой алгоритм сортировки - иначе методом sort() пользоваться. Жду задачу 16.02.
//
//
//