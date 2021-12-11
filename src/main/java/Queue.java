public class Queue {
    private int size;
    private int[] arr;
    private int start;
    private int end;

    public Queue(int size) {
        this.size = size;
        arr = new int[size];            // если я уменьшу это поле в другом методе, то и здесь оно уменьшится?
    }

    public void push(int val) {
        if (end < arr.length) {
            arr[end++] = val;
        } else {
            System.err.println("Queue is full of elements");
        }
    }

    public int remove() {
        int temp = arr[start];

        for(int j = start; j<size-1; j++){
            arr[start] = arr[start+1];
            start++;
        }
        end--;
        int[] newArray = new int[arr.length-size--]; // изменить текущий массив нельзя. Его можно изменить, переписав значения в другой массив. Да?
        System.arraycopy (arr, 0, newArray, 0, size);

        /*for(int i = 0; i < arr.length-size; i++ ) {
                newArray[i] = arr[i];              // ошибка. почему?
            }*/
        return temp;
    }
    }

