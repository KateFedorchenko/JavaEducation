package multithreading.hw;

import beginner.InterfaceTask1;

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
public class OrderedPrints{
    private final AtomicInteger order = new AtomicInteger(1);
    Runnable r = new Runnable() {
        @Override
        public void run() {
            foo();
            bar();
            qwe();
        }
    };


    void foo() {
        while(true) {
            try{
                if(order.compareAndSet(1,2)){
                    System.out.println("foo");
                    order.notify();
                } else {
                    order.wait();
                }
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void bar() {
        while(true) {
            try{
                if(order.compareAndSet(2,3)){
                    System.out.println("bar");
                    order.notify();
                } else {
                    order.wait();
                }
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void qwe() {
        while(true) {
            try{
                if(order.compareAndSet(3,1)){
                    System.out.println("qwe");
                    order.notify();
                } else {
                    order.wait();
                }
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
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
