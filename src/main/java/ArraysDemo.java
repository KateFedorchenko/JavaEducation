public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,0};
        int[] arr2 = new int[] {1,0,3};
        int[] arr3 = new int[] {1,2,3,4,5};
        int[] arr4 = new int[] {1,2,4};
       // System.out.println("isEqual(arr1,arr2) = " + isEqual(arr1, arr2));
       // System.out.println("isEqual(arr1,arr3) = " + isEqual(arr1, arr3));
       // System.out.println("isEqual(arr1,arr1) = " + isEqual(arr1, arr1));
       // System.out.println("isEqual(arr1,arr4) = " + isEqual(arr1, arr4));
       // System.out.println("isEqual(new int[0], new int[0]) = " + isEqual(new int[0], new int[0]));
        System.out.println("getMinValue(arr1) = " + getMinValue(arr1));
        System.out.println("getMinValue(arr2) = " + getMinValue(arr2));
        System.out.println("getMinValue(arr3) = " + getMinValue(arr3));


    }

    static boolean isEqual(int[] lhs, int[] rhs) {
        if(lhs.length != rhs.length) {
            return false;
        } else {   // else - необязательный. так как в основной  ветке есть return
            for(int i=0;i<lhs.length;i++) {
                if(lhs[i]!=rhs[i]) {
                    return false;
                }
            }
            return true;
        }

    }

    static boolean isEqual2(int[] lhs, int[] rhs) {
        if(lhs.length != rhs.length) {
            return false;
        }
        for(int i=0;i<lhs.length;i++) {
            if(lhs[i]!=rhs[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Searches for the minimal value in the given array.
     *
     * @param arr Array.
     * @return Minimal value.
     * @throws AssertionError if array is empty or null.
     *
     */
    static int getMinValue(int[] arr) {
        int minValue = arr[0];
        if(arr.length == 0) {
            System.out.println("Array is empty or null");
        } else {
            for(int i=1;i<arr.length;i++) {
                if(minValue>arr[i]) {
                    minValue = arr[i];
                }
            }
            return minValue;
        }
        return minValue;
    }
}
