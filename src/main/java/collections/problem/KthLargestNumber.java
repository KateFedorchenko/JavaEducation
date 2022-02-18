package collections.problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthLargestNumber {
    public static void main(String[] args) {
        List<Double> nums = new ArrayList<>(List.of(2.1,200.34,1.9,3.3,4.3,54.3,55.5));
        System.out.println(nums);
        System.out.println(findKthLargestElement(nums,3));
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
        //possible solution but it performance poorly when size of nums much bigger than k.
        List<Double> copy = new ArrayList<>(nums);
        copy.sort(Comparator.naturalOrder());
        return copy.get(copy.size()-1);
    }
}

// not really got the idea of "when size of nums much bigger than k" but now it returns the correct value