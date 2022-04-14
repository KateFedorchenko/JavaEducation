//package generics;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//
///**
// * All method should have time complexity of O(1).
// * @param <T>
// */
//public class ForwardList<T> /*implements Iterable<T>*/ {
//    /**
//     * @return  first element of the list.
//     */
//    public T front();
//
//    /**
//     *
//     * @return size of the list.
//     */
//    public T size();
//
//    /**
//     * Removes element from head.
//     * If list is already empty than throws {@link NoSuchElementException}.
//     */
//    public void removeFront();
//
//    /**
//     * Places new element to the front of the list.
//     */
//    public void pushFront(T newElement);
    /*
    @Override public Iterator<T> iterator() {
        return new ForwardListIterator<>();
    }


    private static class ForwardListIterator<T> implements Iterator<T> {
        @Override public boolean hasNext() {
            return false;
        }

        @Override public T next() {
            return null;
        }
    }  */
//}
