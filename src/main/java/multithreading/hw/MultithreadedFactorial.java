package multithreading.hw;

import java.math.BigInteger;


public class MultithreadedFactorial {

    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread running");
        }
    }


    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        System.out.println(getFactorialMultithreaded(4,5));
    }

    /**
     * Calculates factorial e.g.
     * 10! = 10 * 9 * 8 *... * 1
     * @param n means that factorial calculates of n (n! = n * (n-1) * (n-2) * ... * 1)
     * @param threadCount Number of thread need to be spawned for this task.
     * @return result of fact calculation.
     */
    public static BigInteger getFactorialMultithreaded(int n, int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
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
}
