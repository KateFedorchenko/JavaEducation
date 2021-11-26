public class Arrays2D {
    public static void main(String[] args) {
        /*int[][] arr = new int[5][4]; // создаем прямоугольный массив из 5 строк и 4 колонок

        arr[1][2] = -1;

        int[][] arr2 = new int[3][];
        arr2[0] = new int[1];
        arr2[1] = new int[2];
        arr2[2] = new int[3];

        int[][] arr3 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr4 = {{1},{2,3},{4,5,6}};*/
        int[][] arr2d = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //createStairArray(4);
        arraySnakeTraverse(arr2d);
    }

    /**
     *
     * @param arr квадратная матрица
     * @return след матрицы
     */
    static int calculateTrace(int[][] arr) {
        int sum = 0;
        for(int i = 0; i<arr.length;i++) {
            sum+=arr[i][i];
        }
        return sum;
    }

    static int[][] createStairArray(int height){
        int[][] arr = new int[height][];
        for(int i=0;i<arr.length;i++){
            arr[i] = new int[i+1];
        }
        return arr;
    }

    /**
     * Traverses given 2D array in the left-growing spiral way starting from most upper-left element
     * and writes into plain array in that order.
     * e.g.
     * | 1 2 3 |
     * | 4 5 6 | -> | 1 2 3 6 9 8 7 4 5|
     * | 7 8 9 |
     *
     * @param arr2d Non-null two-dimensional rectangle array with non-null elements.
     * @return One-dimensional array.
     */
    static int[] arraySpiralTraverse(int[][] arr2d) {
        return new int[0];
    }

    /**
     * Traverses given 2D array in `snake` way starting from most upper-left element
     * and writes into plain array in that order.
     * e.g.
     *
     * | 1 2 3 |
     * | 4 5 6 | -> | 1 2 3 6 5 4 7 8 9|
     * | 7 8 9 |
     *
     * @param arr2d Non-null two-dimensional rectangle array with non-null elements.
     * @return One-dimensional array;
     */
   // int[][] arr2d = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

    static int[] arraySnakeTraverse(int[][] arr2d) {
        int x = 0;
        int[] res = new int[arr2d[0].length + arr2d[1].length+arr2d[2].length]; // а если я не знаю, какого размера мне нужен массив?
        for(int i = 0; i<arr2d.length;i++) {
            if(i % 2 == 0) {
                for(int j = 0; j<arr2d[i].length; i++) {
                    res[x++] = arr2d[i][j];
                }
            } else {
                for(int j = arr2d[i].length-1; j>=0; j--) {
                    res[x++] = arr2d[i][j];
                }
            }
        }
        return res;             // не работает функция. Почему?
    }
}

