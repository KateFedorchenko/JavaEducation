package multithreading;

import java.util.ArrayList;
import java.util.List;

public class MultiThreading1Demo {
    public static void main(String[] args) throws Exception {
        //Problem count all number from 1 to N
        int cap = 1_000_000_000;
        int threadCount = 4;
        int chunkSize = cap/4;

        List<SummingNumberThread> threads = new ArrayList<>();
        //t1: 0 ... 250_000_000
        //t2: 250_000_000.. 500_000_000;
        //t3: 500_000_000... 750_000_000
        //t4: 750_000_000... 1_000_000_000
        for(int i = 0; i < threadCount; ++i) {
            SummingNumberThread t;
            if (i == threadCount - 1) {
                t = new SummingNumberThread(chunkSize * i, cap + 1);
            } else {
                t = new SummingNumberThread(chunkSize * i, chunkSize * (i + 1));
            }
            t.start();
            threads.add(t);
            //t.join(); it is wrong!!
        }

        for (int i = 0; i < threadCount; i++) {
            threads.get(i).join();
        }

        long result = 0;
        for (int i = 0; i < threadCount; i++) {
            result += threads.get(i).getRes();
        }

        System.out.println("result = " + result);
        System.out.println("calcArithmeticProgressionByFormula(cap) = " + calcArithmeticProgressionByFormula(cap));

    }

    static long calcArithmeticProgressionByFormula(int n) {
        long x = n;
        return x * (x+1)/2;
    }


    static class SummingNumberThread extends Thread {
        int from;
        int to;//not included

        long res;

        public SummingNumberThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public long getRes() {
            return res;
        }

        @Override public void run() {
            for (int i = from; i < to; ++i) {
                res += i;
            }
        }
    }

    static class MyThread extends Thread {

        public MyThread() {
            super("MyAwesomeThread");
        }

        @Override public void run() {
            System.out.println("hello from another thread!");
        }
    }
}
