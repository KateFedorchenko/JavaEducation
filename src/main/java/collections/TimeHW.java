package collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class TimeHW {
    public static void main(String[] args) throws Exception{
        Time oldTime = new Time(11,22);
        Time newTime = new Time(12,22);
        System.out.println(oldTime.compareTo(newTime));
        System.out.println(oldTime.equals(newTime));
        System.out.println(oldTime.hashCode());
        HashSet<Time> hashSet = new HashSet<>();
        hashSet.add(new Time(2,23));
        hashSet.add(new Time(23,23));
        hashSet.add(new Time(12,34));
        System.out.println(hashSet);
        SortedSet<Time> set = new TreeSet<>();
        set.add(new Time(33,44));
        set.add(new Time(60,4));
        set.add(new Time(53,24));
        for (Time s : set) {
            System.out.println(s);
        }
    }

    public static class Time implements Comparable<Time>{
        public final int minutes;
        public final int seconds;


        public Time (int minutes, int seconds) throws Exception {
            if(minutes > 60 || minutes < 0 || seconds > 60 || seconds < 0) {
                throw new Exception("Incorrect state of minutes or seconds.");
            }
            this.minutes = minutes;
            this.seconds = seconds;
        }

        //public Time(){}            // not allowed - why?

        @Override
        public String toString() {
            if(minutes < 10 && seconds < 10) {                            // 03:03
                return "The time is 0"+ minutes +" : 0"+ seconds;
            } else if(minutes < 10 && seconds > 10) {                     // 05:32
                return "The time is 0"+ minutes +" : "+ seconds;
            } else if(minutes > 10 && seconds < 10){                      // 12:02
                return "The time is "+ minutes +" : 0"+ seconds;
            } else {
                return "The time is "+ minutes +" : "+ seconds;            // 12:23
            }
        }

        @Override
        public int compareTo(Time that) {
            if(this.minutes == that.minutes && this.seconds == that.seconds) {
                return 0;
            } else if(this.minutes > that.minutes || this.minutes == that.minutes && this.seconds > that.seconds){
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Time that = (Time) obj;
            return minutes == that.minutes && seconds == that.seconds;
        }

        @Override
        public int hashCode() {
            return Objects.hash(minutes,seconds);
        }
    }
}


// 1) binary search tree (BST) - google for it
// 2) Класс Time. Поля : минуты и секунды. Неизменяемый класс (нельзя прибавить). Но нужно запретить возможность создания объекта
//с некорректным состоянием. Например. 12:66. Для данного класса надо переопределить методы toString, HashCode, Equals + реализовать
// интерфейс Comparable. Проверить что класс корректно хранится в коллекциях TreeSet + HashSet.