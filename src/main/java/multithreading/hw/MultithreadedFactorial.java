package multithreading.hw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class MultithreadedFactorial {
    public static void main(String[] args) throws Exception {
        int factorial = 2;
        int threadCount = 2;
        int chunkSize = factorial / threadCount;

        List<MyFactorialThread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            MyFactorialThread t;
            if (i == threadCount - 1) {
                t = new MyFactorialThread(chunkSize*i,factorial+1); //!
            } else {
                t = new MyFactorialThread(chunkSize*i,chunkSize*(i+1)); //!
            }
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < threadCount; i++) {
            threads.get(i).join();
        }

        long result = 0;
        for (int i = 0; i < threadCount; i++) {
            result += threads.get(i).getRes();          // hard to understand what it is for :/
        }
        System.out.println("result = " + result);
        System.out.println("getFactorialMultithreaded() = " + getFactorialMultithreaded(factorial,threadCount));
    }

    /**
     * Calculates factorial e.g.
     * 10! = 10 * 9 * 8 *... * 1
     *
     * @param n           means that factorial calculates of n (n! = n * (n-1) * (n-2) * ... * 1)
     * @param threadCount Number of thread need to be spawned for this task.
     * @return result of fact calculation.
     */
    public static BigInteger getFactorialMultithreaded(int n, int threadCount) {    // why do I need here the param threadCount?
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n < 2) {
            return BigInteger.ONE;
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


    public static class MyFactorialThread extends Thread {
        int from;
        int to;

        long res;

        public MyFactorialThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public long getRes() {
            return res;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++) {
                res += i;
            }
        }
    }

    static class MyThread extends Thread {
        public MyThread(){
            super("MyAwesomeThread");
        }
        @Override
        public void run(){
            System.out.println("hello from another thread!");
        }
    }
}
