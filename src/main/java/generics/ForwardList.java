package generics;


import java.util.*;

/**
 * All method should have time complexity of O(1).
 *
 * @param <T>
 */
public class ForwardList<T> implements Iterable<T> {
    private class Node {
        private T val;
        private Node next;

        public Node(T val) {
            this.val = val;
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

    }
    private Node head;

    /**
     * @return first element of the list.
     */
    public T front() {
        return head.val;
    }

    /**
     * @return size of the list.
     */
    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * Removes element from head.
     * If list is already empty than throws {@link NoSuchElementException}.
     */
    public void removeFront() {
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        }
        Node temp = head;
        head = head.next;
    }

    /**
     * Places new element to the front of the list.
     */
    public void push(T newElement) {
        head = new Node(newElement, head);
    }

    /**
     * Adds all element from Iterable parameter.
     */
    public void addAll(List<T> it){
        Iterator<T> iterator = it.iterator();
        while(iterator.hasNext()) {
            T element = iterator.next();
            this.push(element);
        }
    }

    /**
     * @return all elements in a form of java.util.ArrayList
     */
    public ArrayList<T> getAllList(){
        ArrayList<T> arrayList = new ArrayList<>();
        for (T x : this) {
            arrayList.add(x);
        }
        return arrayList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.val).append(" ->");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ForwardListIterator();
    }

    private class ForwardListIterator implements Iterator<T> {
        private Node cur = head;


        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T res = cur.val;
            cur = cur.next;
            return res;
        }
    }
}
