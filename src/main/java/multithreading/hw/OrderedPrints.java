package multithreading.hw;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Change only methods foo() bar() and qwe() and add necessary fields so current program will always print next sequence:
 * foo
 * bar
 * qwe
 */
public class OrderedPrints {
    void foo() {
        System.out.println("foo");
    }

    void bar() {
        System.out.println("bar");
    }

    void qwe() {
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
