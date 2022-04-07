package collections;

import java.util.HashMap;
import java.util.Objects;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<MyKey,String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(new MyKey(i),"test");
        }
        System.out.println();
    }

    public static class MyKey{
        int x;

        public MyKey(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyKey myKey = (MyKey) o;
            return x == myKey.x;
        }

        @Override
        public int hashCode() {
            return 0;           // bad hashcode but it is consistent  -> collision happens
        }
    }

    public static void hashMapResizing() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i),"test");
        }
        System.out.println(map);
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i*i+11),"test");
        }
        System.out.println(map);
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i*i+200),"test");
        }
        System.out.println(map);
    }

}


