public class Introduction {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[] {1,2,1,2,3,4,5,6,7,8};
        int[] arr2 = new int[] {1,2,1,2,3,4,5,6,7};
        int result1 = sum(arr);
        int result2 = sum(arr2);
        System.out.println("arr[0] = " + arr[0]);
        System.out.println(result1);
        System.out.println(result2);

    }

    static int sum(int[] x) {
        int sum =0;
        x[0] = -120;

        for(int i=0;i<x.length;i++) {
            sum+=x[i];
        }
        return sum;
    }

}
