public class Arrays2D {
    public static void main(String[] args) {
        int[][] arr = new int[5][4]; // создаем прямоугольный массив из 5 строк и 4 колонок

        arr[1][2] = -1;

        int[][] arr2 = new int[3][];
        arr2[0] = new int[1];
        arr2[1] = new int[2];
        arr2[2] = new int[3];

        int[][] arr3 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr4 = {{1},{2,3},{4,5,6}};



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
        return null;
        //создать лестничный массив заданного размера
    }


}

