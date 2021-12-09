public class Stack {
    private String[] store;
    private int[] ints;    // int[] type of variable is added
    private int size;

    public Stack(int length) {
        ints = new int[length];
    }

   public void push(String str) {
        if (size < store.length) {
            store[size++] = str;
        } else {
            System.err.println("Stack is overwhelmed");
        }
    }

    public void push(int val) {
        if (size < ints.length) {
            ints[size++] = val;
        } else {
            System.err.println("Stack is overwhelmed");
        }
    }

    public int pop() {
        if (size > 0) {
            return ints[--size];
        } else {
            System.err.println("Stack is empty");
            return -1;

        }
    }
}




