package multithreading;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class MultithreadingAtomics {
    static volatile long l = 0;

    static class Doer {
        AtomicBoolean completed = new AtomicBoolean(false);
        Runnable r;

        public Doer(Runnable r) {
            this.r = r;
        }

        void doOnce() {
            if (completed.compareAndSet(false, true)) {
                System.out.println("Doer running on thread = " + Thread.currentThread().getName());
                r.run();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Doer doer = new Doer(() -> System.out.println("hello!"));
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(
                new Thread(() -> {
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                    } catch (Exception e) {}
                    doer.doOnce();
                })
            );
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }


    static long addAndGet() {
        l++;
        return l;
    }

    static void atomicIncrement() throws Exception {
        AtomicLong al = new AtomicLong();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(
                () -> {
                    for (int j = 0; j < 10_000; j++) {
                        al.addAndGet(2);
                        l+=2;
                    }
                }
            );

            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("al = " + al);
        System.out.println("l = " + l);
    }

    static void atomicOperations() throws Exception {
        Thread t1 = new Thread(
            () -> {
                l = 0b1111111111111111111111111111111111111111111111111111111111111111L;//write
            }
        );

        Thread t2 = new Thread(
            () -> {
                System.out.println(l);
            }
        );


        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
