package multithreading.hw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NTimeDoerMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        NTimeDoer doer = new NTimeDoer(4, () -> System.out.println("Hello from doer"));
        for (int i = 0; i < 10; ++i) {
            es.submit(
                    () -> doer.doIt()
            );
        }
        es.shutdown();
        System.out.println("Finished!");
    }
}
