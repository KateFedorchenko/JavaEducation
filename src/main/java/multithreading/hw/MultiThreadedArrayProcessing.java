package multithreading.hw;

import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadedArrayProcessing {

    public static void main(String[] args) {
        int[] arr = generateArray(1000);

        int idx = findLargestElementIndexMultiThreaded(arr, 2);
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
    static int findLargestElementIndexMultiThreaded(int[] arr, int threadCount) {
        return -1;
    }
}
