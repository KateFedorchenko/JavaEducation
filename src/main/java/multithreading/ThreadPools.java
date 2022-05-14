package multithreading;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPools {
    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        for (int i = 0; i < 1000; i++) {
            Callable<BigDecimal> fact10 = new Callable<BigDecimal>() { // () -> fact(10)
                @Override public BigDecimal call() throws Exception {
                    return fact(10);
                }
            };
            Future<BigDecimal> fut = executorService.submit(fact10);
        }


        //System.out.println(fut.get());

        System.out.println(executorService);
        executorService.shutdown();
    }

    static BigDecimal fact(int n) {
        BigDecimal res = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigDecimal.valueOf(i));
        }

        return res;
    }


    static void simpleFuture() throws Exception {
        Future<?> fut = executorService.submit(
            () -> System.out.println("Hello!")
        );

        fut.get();
        System.out.println(" World");

        executorService.shutdown();
    }

    static void executeUsage() {
        executorService.execute(() -> {
            try {
                Thread.sleep(5_000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Foo");
            System.out.println("bar");
        });

        executorService.shutdownNow();
    }
}
