public class ArraysAdvancedDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{-10,-9,-8,-7,-6,-5,-3,-1,0,8};
        int res = binarySearch(arr, 0, arr.length, -2);
        System.out.println(res);
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
}
