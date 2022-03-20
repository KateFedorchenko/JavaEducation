package collections;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<Data> set = new TreeSet<>();
        set.add(new Data(2));
        set.add(new Data(3));
        set.add(new Data(4));
        set.add(new Data(5));
        System.out.println(set);
    }

    public static void treeSet() {
        SortedSet<String> set = new TreeSet<>();  // no equals - no hashcode
        set.add("tree");
        set.add("bar");
        set.add("set");
        set.add("z");
        set.add("x");
        set.add("w");
        set.add("Foo");
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static class Data implements Comparable<Data>{
        int x;

        public Data(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return "Data { x = " + x + " }";
        }

        @Override
        public int compareTo(Data that) {
            if(this.x > that.x) {
                return 1;
            } else if(this.x == that.x){
                return 0;
            } else {
                return -1;
            }
        }
    }

}


// 1) binary search tree (BST) - google for it
// 2) Класс Time. Поля : минуты и секунды. Неизменяемый класс (нельзя прибавить). Но нужно запретить возможность создания объекта
//с некорректным состоянием. Например. 12:66. Для данного класса надо переопределить методы toString, HashCode, Equals + реализовать
// интерфейс Comparable. Проверить что класс корректно хранится в коллекциях TreeSet + HashSet.