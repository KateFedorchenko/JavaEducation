package collections;

import java.util.HashSet;
import java.util.Objects;

public class HashSetDemo {
    public static class Data{
        int x;

        public Data(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
           return "Data { x = "+x+" }";
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(this.getClass() != obj.getClass()) {
                return false;
            }
            Data that = (Data)obj;
            return that.x == this.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }
    }

    public static void main(String[] args) {
        HashSet<Data> hashSet = new HashSet<>();
        hashSet.add(new Data(2));
        hashSet.add(new Data(3));
        hashSet.add(new Data(4));
        hashSet.add(new Data(3));
        hashSet.add(new Data(33));
        hashSet.add(new Data(35));
        System.out.println(hashSet);
    }
}
