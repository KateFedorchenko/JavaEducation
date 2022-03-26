package collections;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetBenchmark {
    public static void main(String[] args) {
        int size = 1_000_000;      //100k = 32.600 ns // 1m = 20.200 ns
        TreeSet<Long> set = createRandomTreeSet(size);
        long valueToSearch = 20;
        long time = System.nanoTime();
        boolean found = set.contains(valueToSearch);
        long interval = System.nanoTime()-time;
        System.out.println(interval);



    }

    public static TreeSet<Long> createRandomTreeSet(int size){
        long time = System.currentTimeMillis();
        Random r = new Random(42);
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            tree.add(r.nextLong());
        }
        System.out.print("Create random tree set ");
        System.out.println(System.currentTimeMillis()-time);
        return tree;
    }
}
