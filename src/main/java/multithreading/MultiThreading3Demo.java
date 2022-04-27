package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreading3Demo {


    public static void main(String[] args) throws Exception {
        List<Long> numbers = new ArrayList<>();
        Object mutex = new Object(); //Mutual Exclusion // Monitor
        int size = 100_000;

        List<Thread> threads = new ArrayList<>();
        for (int x = 0; x < 6; x++) {
            Runnable r = new Runnable() {
                @Override public void run() {
                    for (int i = 0; i < size; i++) {
                        long randomLong = ThreadLocalRandom.current().nextLong();
                        randomLong *= randomLong;

                        synchronized (mutex) {
                            numbers.add(randomLong);
                            numbers.get(i);
                        }
                    }
                }
            };


            Thread t = new Thread(r);

            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(numbers.size());
    }
}
