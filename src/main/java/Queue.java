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
        if (start >= 0) {
            return arr[start++];
        } else {
            System.err.println("Queue is empty");
            return -1;
        }
    }
}
