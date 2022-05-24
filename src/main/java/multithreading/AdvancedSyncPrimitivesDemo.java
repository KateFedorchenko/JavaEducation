package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AdvancedSyncPrimitivesDemo {
    static LongAdder sharedValue = new LongAdder();     // array in fact
    static int[] values = {1, 3, 5, 8, 13};
    static ExecutorService executorService = Executors.newFixedThreadPool(5);


    private static void sleepRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < values.length; i++) {
            int j = i;
            executorService.submit(() -> {
                sharedValue.add(values[j]);           // like a fraud -> not bad ---> j == i
                latch.countDown();
                for (int k = 0; k < 5; k++) {
                    sleepRandomTime();
                }
                System.out.println("additional thread is completed");
            });
        }
        latch.await();
        System.out.println(sharedValue.sum());
        executorService.shutdown();
    }

    public static void countDownLatchSimpleUsage() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);      // FQCN -> java.util.concurrent.CountDownLatch   Alt+enter
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            sleepRandomTime();
            System.out.println("hello");
            latch.countDown();
        });
        executorService.submit(() -> {
            sleepRandomTime();
            System.out.println(" privet");
            latch.countDown();
        });
//        latch.countDown();
        latch.await();                      // blocking method
        System.out.println(" world!");
        executorService.shutdown();
    }
}


// TimeStampedLock to be looked through
// 1) NTimeDoer to do --> Runnable r () -> { n > 0; }  do()  to be called == n. Exception to be taken into consideration