package multithreading.hw;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadedArrayProcessing {

    public static void main(String[] args) throws Exception {
        int[] randomArr = generateArray(10);
        System.out.println(Arrays.toString(randomArr));
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
    public static int findLargestElementIndexMultiThreaded(int[] arr, int threadCount) throws Exception {
        int size = arr.length;
        int range = size / threadCount;
        List<Thread> threads = new ArrayList<>();
        List<FindMaxElementIndex> tasks = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int startAt = i * range;
            int endAt;
            if(i == threadCount-1){
                endAt = size;
            } else {
                endAt = startAt+range;
            }
            FindMaxElementIndex f = new FindMaxElementIndex(arr, startAt, endAt);
            Thread t = new Thread(f);
            t.start();
            threads.add(t);
            tasks.add(f);
        }
        int maximum = 0;
        int maxIdx = 0;
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
            if (maximum < tasks.get(i).getMax()) {
                maximum = tasks.get(i).getMax();
                maxIdx = tasks.get(i).getIdx();
            }
        }
        return maxIdx;
    }


    public static class FindMaxElementIndex implements Runnable {
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

        public int getIdx() {
            return idx;
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
