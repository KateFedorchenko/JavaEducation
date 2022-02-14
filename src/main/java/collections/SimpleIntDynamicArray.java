package collections;

public class SimpleIntDynamicArray {
    private int[] data = new int[10];
    private int size = 0;

    /**
     * Adds a new element with value 'x' to the end of the array.
     * @param x value of the new element.
     */
    public void add(int x) {
        if(size == data.length) {
            int[] arr = new int[data.length +1];
            for (int i = 0; i < data.length; i++) {
                arr[i] = data[i];
            }
            data = arr;
        }
        data[size++] = x;
    }

    /**
     * Removes element with chosen index.
     * @param idx index of an element to delete.
     */
    public void remove(int idx) {
        if(data[idx] == data[size-1]) {
            data[size-1] = 0;
            return;
        }
        for(int i = data[idx]; i < data.length-1; i++) {
            data[i] = data[i+1];
        }
    }

    /**
     * Changes the element with the chosen index to the new value.
     * @param idx index of an element to change.
     * @param x value of the new element.
     */
    public void set(int idx, int x) {
        data[idx] = x;
    }

    /**
     * Gets the value of the element with the chosen index.
     * @param idx index of an element to get.
     * @return value of the chosen element.
     */
    public int get(int idx) {
        return data[idx];
    }

    /**
     * Gets the size of the array.
     * @return the size of the array.
     */
    public int size() {
        return size;
    }
}
