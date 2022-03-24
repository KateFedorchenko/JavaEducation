package collections.problem;

/**
 * You are given single node instance - root of some binary tree.
 * Please implement algorithm of searching BST for given value.
 */
public class FindValueInBST {
    /**
     * Node of BST
     * @param <T> Type contained in BST
     */
    static class Node<T extends Comparable<T>> {
        private T val;
        private Node<T> left;
        private Node<T> right;

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(T val) {
            this.val = val;
        }

        public boolean containValue(T valToSearch) {
            // place your code here.
            // Think about recursive algorithm.
            return false;
        }
    }

}
