package multithreading.hw;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Change only methods foo() bar() and qwe() and add necessary fields so current program will always print next sequence:
 * foo
 * bar
 * qwe
 */
public class OrderedPrints {
    private final AtomicInteger order = new AtomicInteger(0);
    Runnable r = new Runnable() {
        @Override
        public void run() {
            foo();
            bar();
            qwe();
        }
    };

    void foo() {
        if(order.compareAndSet(0,1)){
            System.out.println("foo");
        }
    }

    void bar() {
        if(order.compareAndSet(1,2)){
            System.out.println("bar");
        }
    }

    void qwe() {
        if(order.compareAndSet(2,0)){
            System.out.println("qwe");
        }
    }

    static void sleepRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        OrderedPrints obj = new OrderedPrints();

        Thread t1 = new Thread(
            () -> {
                sleepRandomTime();
                obj.qwe();
            }
        );

        Thread t2 = new Thread(
            () -> {
                sleepRandomTime();
                obj.bar();
            }
        );

        Thread t3 = new Thread(
            () -> {
                sleepRandomTime();
                obj.foo();
            }
        );

        List<Thread> threads = List.of(t1, t2, t3);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
