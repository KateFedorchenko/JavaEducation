package multithreading.hw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadedArrayProcessing {

    public static void main(String[] args) throws Exception{
        int[] randomArr = generateArray(10);
        System.out.println(findLargestElementIndexMultiThreaded(randomArr, 4));
    }

    static int[] generateArray(int size) {
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = ThreadLocalRandom.current().nextInt();
        }
        return res;
    }

    /**
     * Returns index of the largest element in array;
     */
    public static int findLargestElementIndexMultiThreaded(int[] arr, int threadCount) throws Exception{
        int size = arr.length;
        int range = size / threadCount;

        List<FindMaxElementIndex> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int startAt = i * range;
            int endAt = startAt + range;
            FindMaxElementIndex f = new FindMaxElementIndex(arr,startAt,endAt);
            f.start();
            threads.add(f);
        }

        for (FindMaxElementIndex thread : threads) {
            thread.join();
//            getMax() ????
        }
        return 0;
    }


    public static class FindMaxElementIndex extends Thread implements Runnable {        // ok?
        private int startIndex;
        private int endIndex;
        private int[] array;

        int max = Integer.MIN_VALUE;
        int idx;

        public FindMaxElementIndex(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public int getMax() {
            return max;
        }

        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                if (array[i] > max) {
                    max = array[i];
                    idx = i;
                }
            }
        }

    }
}
