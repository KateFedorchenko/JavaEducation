public class Queue {
    private int size;
    private int[] arr;
    private int start;
    private int end;

    public Queue(int size) {
        this.size = size;
        arr = new int[size];
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
        size--;
        return temp;
    }
    }

