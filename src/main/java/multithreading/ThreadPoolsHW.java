package multithreading;

import java.math.BigDecimal;
import java.util.concurrent.*;

public class ThreadPoolsHW {
    static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());      // >12  not ok

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<BigDecimal> fib = new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {
                return fib(3);
            }
        };
        Future<BigDecimal> fut = executorService.submit(fib);
        System.out.println(fut.get());
        System.out.println(Runtime.getRuntime().availableProcessors()); // logical cores = 12
        executorService.shutdown();
    }

    static BigDecimal fib(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Please provide non-negative param");
        }
        if (x == 0) {
            return BigDecimal.ZERO;
        }
        if (x == 1 || x == 2) {
            return BigDecimal.ONE;
        }
        return fib(x - 1).add(fib(x - 2));
    }
}
