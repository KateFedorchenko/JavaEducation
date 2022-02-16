package collections.problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthLargestNumber {
    /**
     * Find the kTh largest element in the list.
     * It is expected that nums list won't be modified in process.
     *
     * @param nums List.
     * @param k k.
     * @throws IllegalArgumentException If size of list lesser than k
     * @return KTh largest element in the list.
     */
    public static double findKthLargestElement(List<Double> nums, int k) {
        //possible solution but it performance poorly when size of nums much bigger than k.
        List<Double> copy = new ArrayList<>(nums);

        copy.sort(Comparator.naturalOrder());

        return copy.get(k-1);
    }


}
