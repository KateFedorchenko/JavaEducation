package beginner;

public class Queue {
    private int[] arr;
    private int end;

    public Queue(int size) {
        arr = new int[size];
    }

    public void push(int val) {
        if (end < arr.length) {
            arr[end++] = val;
        } else {
            System.err.println("beginner.Queue is full of elements");
        }
    }

    public int remove() {
        int temp = arr[0];
        for(int i = 0; i < arr.length-1;i++){
            arr[i] =arr[i+1];
        }
        return temp;

    }
}

