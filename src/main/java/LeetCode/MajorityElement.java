package LeetCode;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        System.out.println(findMajorityElement(arr));
    }

    public static int findMajorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == majority) {
                i++;
            }
            int currentCount = 0;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    currentCount++;
                }
            }
            if(currentCount > count){
                count = currentCount;
                majority = nums[i];
            }
        }
        return majority;
    }
}
