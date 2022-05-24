package multithreading.hw;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NTimeDoer implements Runnable {
    Runnable r;
    static CountDownLatch latch;
    static ExecutorService executorService = Executors.newFixedThreadPool(5);


    public NTimeDoer(int n, Runnable r) throws Exception {
        if (n < 0) {
            throw new Exception("n cannot be 0");
        }
        latch = new CountDownLatch(n);
        this.r = r;
    }

    @Override
    public void run() {
        try {
            executorService.submit(() -> {
                try {
                    latch.countDown();
                    doIt();
                    latch.await();
                    System.out.println("Finished!");
                    executorService.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            executorService.shutdown();
            e.printStackTrace();
        }
    }


    public void doIt() {
        try {
            System.out.println("Start!");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


