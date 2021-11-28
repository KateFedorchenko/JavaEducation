public class ArraysAdvancedDemo {
    public static void main(String[] args) {
       // int[] arr = new int[]{-10,-9,-8,-7,-6,-5,-3,-1,0,8};
        //int res = binarySearch(arr, 0, arr.length, -2);
        //System.out.println(res);
        int[] arr2 = new int[]{2,1};
        swapBubble(arr2);
    }

    static int binarySearch(int[] arr, int start, int end, int x) {
        if(end<=start) {
            return -1; // standard value
        }
        int mid = (end+start)/2;
        if(x>arr[mid]) {
            return binarySearch(arr,mid+1,end,x);
        } else if (x < arr[mid]) {
            return binarySearch(arr,start,mid,x);
        } else {  // when x == arr[mid]
            return mid;
        }

    }

    // Сортировка вставкой или пузырьком . Отсортирвать одномерный массив с помощью этих двух видов сортировок.
    // +1 задача по запросу

                                    /* Bubble Sorting */
    static void swapValuesForSorting(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static int[] swapBubble (int[] arr) {
        boolean isSorted = false;  // for the first cycle
        while(!isSorted){             // ? why cannot I put here "isSorted = false"?
            isSorted = true;   // TRUE when the IF-statement does not occur
            for(int i = 0; i<arr.length-1; i++) {   //arr.length-1 because of arr[i+1]
                if(arr[i] > arr[i+1]) {
                    swapValuesForSorting(arr, i, i+1);
                    isSorted = false;   //one sorting has just happened, so the array must be looked through again
                }
            }
        }
        return arr;
    }
}
