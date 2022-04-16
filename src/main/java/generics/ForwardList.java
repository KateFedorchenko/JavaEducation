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

        public Node getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public T getVal() {
            return val;
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
    public int size() {                // size should be counted in 'int', no? Why T?
        Node temp = head;
        int count = 0;
        while(temp != null){
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
        if (head == null) {
            head = new Node(newElement);
        } else {
            head = new Node(newElement,head);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Node cur = head; cur != null; cur = cur.next) {
            str = str + cur.val.toString()+ " -> ";
        }
        return str;
    }

    @Override public Iterator<T> iterator() {
        return new ForwardListIterator<>();
    }


    private class ForwardListIterator<T> implements Iterator<T> {
        private Node head;


        @Override public boolean hasNext() {
            return head.hasNext();
        }

        @Override public T next() {
            //return head.getNext().getVal(); // why?
            return null;
        }
    }
}
