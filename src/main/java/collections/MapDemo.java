package collections;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) throws Exception{
        searchMapWithKeyAndValue();
        task();
    }



    public static void searchMapWithKeyAndValue(){
        Map<Long, String> map = new HashMap<>();
        int count = 100;
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            long key = r.nextLong();
            int wordSize = r.nextInt(10) + 3; //  3 - 12
            char[] arr = new char[wordSize];
            for (int j = 0; j < wordSize; j++) {
                arr[j] = (char) ('a' + r.nextInt(26)); //0 - 25 generate a string
            }
            String value = new String(arr); // generate key and value
            map.put(key, value);
        }
        System.out.println(map);
//        map does not implement Iterable

        map.entrySet(); // Set<Entry<K,V>>                       // VIEW
        map.keySet(); // Set<K>  --> no Value takes part in      // VIEW
        map.values(); // Collection<V>                           // VIEW

        // HW: итерация через  map.values()  --> надо найти самое первое и самое последнее слвоо по алфавиту
        List<String> mapValues = new ArrayList<>(map.values()); // extra space needed -> bad    O(n)
        Collections.sort(mapValues);                            // time complexity -> bad       O(nlogn)  + extra space needed -> bad    O(n)
        String first = mapValues.get(0);
        System.out.println("The first word is " + first);
        String last = mapValues.get(mapValues.size()-1);
        System.out.println("The last word is " + last);


        //TODO
        for (String value : map.values()) {                   // better to use

        }
    }

    public void searchMap() {
        Map<Integer, String> map = Map.of(0, "foo", 42, "bar", 10, "qwe"); // creates a new map with type of key Integer and type of value String // key type => should be immutable
        List<String> list = List.of("foo", "bar", "qwe");
        System.out.println("map.get(0) = " + map.get(0));
        System.out.println("map.containsKey() = " + map.containsKey(0)); //containsValue is not used often
        map.put(32, "pop");
    }



    public static void task() throws Exception{
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, provide the first digit and press Enter");
        String first = scanner.nextLine();
        throwException(map,first);
        System.out.println("Please, provide the second digit and press Enter");
        String second = scanner.nextLine();
        throwException(map,second);
        int firstNum = map.get(first);
        int secondNum = map.get(second);
        System.out.println("Your sum is " + (firstNum + secondNum));  //0+1 = 1
    }

    public static void throwException(Map<String,Integer> map, String word) throws Exception{
        boolean result = map.containsKey(word);
        if(!result) {
            throw new Exception("Your digit is wrong! No value in map to be found with such key");
        }
    }
}
