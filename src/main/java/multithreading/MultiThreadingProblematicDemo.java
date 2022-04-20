package multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadingProblematicDemo {

    static class Data {
        AtomicLong x = new AtomicLong(0);
        volatile long y = 0;

    }


    public static void main(String[] args) throws Exception {
        int count = 1_000_000;
        Data data = new Data();

        ForkJoinPool.commonPool().execute(
            () -> {
                for (int i = 0; i < count; i++) {
                    data.x.getAndAdd(1);
                    data.y++;
                }
            }
        );

        ForkJoinPool.commonPool().execute(
            () -> {
                for (int i = 0; i < count; i++) {
                    data.x.getAndAdd(1);
                    data.y++;
                }
            }
        );

        Thread.sleep(1000);

        System.out.println("data.x = " + data.x);
        System.out.println("data.y = " + data.y);
    }
}
