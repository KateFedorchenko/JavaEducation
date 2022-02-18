package collections.problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthLargestNumber {
    public static void main(String[] args) {
        List<Double> nums = new ArrayList<>(List.of(12.23121,20.421434,30.912421,3.3,4.3241124,54.3,55.24124215,489.2,4.5,4.6,4.7,4.2,3.2,4.3,4.9,4.8,55.2,53.2,755.2,342.2,53.2));
        System.out.println(nums);
        System.out.println(findKthLargestElement(nums,10));
    }
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
        if(nums.size() < k) {
            throw new IllegalArgumentException("Too small to find largest element in the list");
        }
        double maxValue = nums.get(0);
        for(int i = 1; i < k; i++) {
            if(maxValue < nums.get(i)) {
                maxValue = nums.get(i);
            }
        }
        return maxValue;
    }

}
