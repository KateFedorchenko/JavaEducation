package collections;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<Data> set = new HashSet<>();
        Data d1 = new Data("foo");             // four links
        Data d2 = new Data("foo");
        Data d3 = d1;
        Data d4 = new Data("bar");
        System.out.println("set.add(d1) = " + set.add(d1));
        System.out.println("set.add(d2) = " + set.add(d2));
        System.out.println("set.add(d3) = " + set.add(d3));   //false
        System.out.println("set.add(d4) = " + set.add(d4));
        System.out.println(d1.equals(d2));
       // Object s = 1;
       // String ss = (String)s;       // safe
    }

    public static class Data {
        public String str;

        @Override
        public int hashCode() {
            return 0;                     // ctrl+O  --> @override // ctrl + shift + A --> search
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("Equals calls");
            if(this == obj) {
                return true;
            }
            if(this.getClass() != obj.getClass()) {
                return false;
            }
            Data other = (Data)obj;       // casting --> (safe cast)
            return this.str.equals(other.str);
        }

        public Data(String str) {
            this.str = str;
        }
    }

    public static void copy(){
        Set<String> strings = new HashSet<>();
        boolean f1 = strings.add("foo");           // boolean --> no void. Returns true. No duplicates are possible in Set<>. Method equals() helps.
        boolean f2 = strings.add("foo");           // returns false
        System.out.println(f1);
        System.out.println(f2);
    }
}

