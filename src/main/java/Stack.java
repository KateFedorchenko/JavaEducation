public class Stack {
    private String[] store = new String[10]; // constructor with one int to be added
    private int size;  //

    public void push(String str) {
        if(size < store.length) {
            store[size++] = str;
        } else {
            System.err.println("Stack is overwhelmed");
        }
    }

    public String pop() {
        if(size >0) {
            String copy = store[--size];
            store[size] = null;
            return copy;
        } else {
            System.err.println("Stack is empty");
            return null;
        }

    }
}

// queue - сделать очередь.  LIFO