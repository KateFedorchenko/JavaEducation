package multithreading.hw;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Change only methods foo() bar() and qwe() and add necessary fields so current program will always print next sequence:
 * foo
 * bar
 * qwe
 */
public class OrderedPrintsSynchronized {
    private final AtomicInteger order = new AtomicInteger(1);

    void foo() {
        synchronized (order) {
            System.out.println("foo");
            order.set(2);
            order.notifyAll();
        }
    }

    void bar() {
        try {
            synchronized (order) {
                while (!order.compareAndSet(2, 3)) {
                    System.out.println("Bar - Loop");
                    order.wait();
                }
                System.out.println("bar");
                order.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void qwe() {
        try {
            synchronized (order) {
                while (!order.compareAndSet(3, 4)) {
                    System.out.println("Qwe - Loop");
                    order.wait();
                }
                System.out.println("qwe");
                order.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
        OrderedPrintsSynchronized obj = new OrderedPrintsSynchronized();

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
