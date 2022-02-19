package collections.problem;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String[] strings = {"foo", "bpp", "qwe"};
        List<String> list = Arrays.asList(strings);
        strings[1] = "ef";
        list.set(0,"hd");
        System.out.println(Arrays.toString(strings));
        list.add("f");   // exception

        System.out.println(list.get(1));
        List<Integer> nums = new ArrayList<>(List.of(1, 3, 55, 125, 100, 4, 20, 1, 4));   // OR Arrays.asList(); - any difference? // another syntax -->  List<Integer> integers = new List<>(List.of((1,2,3,4,5,1,2,3)) does not work;
        System.out.println(nums);
        Collections.sort(nums);
        //insertionSorting(nums);
        //removeDuplicates(nums);
        System.out.println(nums);
    }

    /**
     * Remove duplicates values from given sorted array in-place.
     *
     * @param nums Sorted array.
     */
    public static void removeDuplicates(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            int valueForI = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {   // end --> start
                int valueForJ = nums.get(j);
                if (valueForI == valueForJ) {
                    nums.remove(j);
                }
            }
        }
    }

    static List<Integer> insertionSorting(List<Integer> arr) {
        int currentElement;
        int index;
        for (int i = 0; i < arr.size(); i++) {
            currentElement = arr.get(i);
            index = i;
            while (i > 0 && arr.get(i - 1) > currentElement) {
                arr.set(i, arr.get(i - 1));                    // arr.get(i) should be a variable. How to make it so within ArrayList scope?
                index--;
            }
            arr.set(i, currentElement);
        }
        return arr;
    }
}


//Questions:
// 1) I did smth that published all methods of List inside the  List<Integer> integers = new List<Integer>() {........}
// 2) Differences among several initializations  ArrayList<>(List.of()); -- Arrays.asList(); -- .....
// 3) How to use my sorting method for List<Integer> scope if there are problems with arr.get(i) -- which is not a variable and cannot be made so.