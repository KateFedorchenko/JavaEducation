package multithreading.hw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class MultithreadedFactorial {
    public static void main(String[] args) throws Exception {
        long currentTime = System.currentTimeMillis();
        System.out.println("getFactorialMultithreaded(5,1) = " + getFactorialMultithreaded(10000, 4));
        System.out.println(System.currentTimeMillis() - currentTime);
    }

    /**
     * Calculates factorial e.g.
     * 10! = 10 * 9 * 8 *... * 1
     *
     * @param n           means that factorial calculates of n (n! = n * (n-1) * (n-2) * ... * 1)
     * @param threadCount Number of thread need to be spawned for this task.
     * @return result of fact calculation.
     */
    public static BigInteger getFactorialMultithreaded(int n, int threadCount) throws Exception{
        if (n < 2) {
            return BigInteger.ONE;
        }
        int chunkSize = n / threadCount;            // how many operations per one thread
        List<MyFactorialThread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {     // create threads
            int end;
            if(i == threadCount - 1) {
                end = n + 1;
            } else {
                end = chunkSize * (i + 1);
            }
            MyFactorialThread f = new MyFactorialThread(chunkSize * i, end);
            f.start();
            threads.add(f);
        }
        BigInteger factorial = BigInteger.ONE;
        for (MyFactorialThread thread : threads) {
            thread.join();                              // blocks the main thread until other thread is working
            factorial = factorial.multiply(thread.getRes());
        }
        return factorial;
    }


    public static class MyFactorialThread extends Thread {
        int from;
        int to;
        BigInteger res = BigInteger.ONE;

        public MyFactorialThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public BigInteger getRes() {
            return res;
        }

        @Override
        public void run() {
            int from = Math.max(this.from,1);       // 'from' can be 0
            for (int i = from; i < to; i++) {
                res = res.multiply(BigInteger.valueOf(i));
            }
        }
    }
}
