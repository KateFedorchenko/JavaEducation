package multithreading.hw;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderPrintsAtomic {
    private final AtomicInteger order = new AtomicInteger(1);

    void foo() {
        System.out.println("foo");
        order.set(2);
    }

    void bar() {
        while (!order.compareAndSet(2, 3)) {
            Thread.onSpinWait();
        }
        System.out.println("bar");
    }

    void qwe() {
        while (!order.compareAndSet(3, 4)) {
            Thread.onSpinWait();
        }
        System.out.println("qwe");
    }

    static void sleepRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        OrderPrintsAtomic obj = new OrderPrintsAtomic();

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
