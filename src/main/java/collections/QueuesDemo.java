package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueuesDemo {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("foo");                  // the same as offerFirst()
        stack.pop();                           // the same as pollFirst()
    }

    public static void queueThrowingInterface(){
        Queue<String> queue = new LinkedList<>();
        queue.add("foo");                       // to the end added
        queue.add("qwe");
        queue.add("swe");
        System.out.println(queue.remove());     // w/o param removes the el at the beginning
        //System.out.println(queue.remove());
        //System.out.println(queue.remove());
        //System.out.println(queue.remove());    // Exception <-- no element left
        System.out.println(queue.element());     // get the first el -- no removing
        // all methods throw Exceptions      --> not ok to use
    }
    public static void queueNotThrowingInterface(){
        Queue<String> queue =  new LinkedList<>();    // LinkedList = list + queue (more useful)
        queue.offer("foo");
        queue.offer("qwe");
        queue.offer("bar");
        queue.poll();           // to get an el like remove() but no Exception when we get to the end --> null
        queue.peek(); // like element() for the first el
        // better to use these methods()
    }
    public static void deque(){
        Deque<String> deque = new ArrayDeque<>(); // to pronounce like ДЕК // ArrayDeque like ArrayList but still it differs
        deque.offerFirst("qwe");
        deque.offerLast("bar");
        deque.offerFirst("foo");
        System.out.println(deque);          //[foo, qwe, bar]
        deque.pollFirst();                  // foo
        deque.pollLast();                   // bar
        deque.peekFirst();
        deque.peekLast();
    }
}

