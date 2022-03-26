package collections.problem;

import collections.TimeHW;

/**
 * You are given single node instance - root of some binary tree.
 * Please implement algorithm of searching BST for given value.
 */
public class FindValueInBST {
    /**
     * Node of BST
     *
     * @param <T> Type contained in BST   //Параметр T в угловых скобках называется универсальным параметром, так как вместо него можно подставить любой тип.
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
            if(valToSearch == null){
                return false;
            }
            Node<T> node = this;
            while (node != null) {
                if (valToSearch.compareTo(node.val) == 0) {
                    return true;
                }
                if (valToSearch.compareTo(node.val) < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return false;
        }

        public boolean containValueRecursive(T valToSearch){
            if(valToSearch.compareTo(this.val) == 0){
                return true;
            }
            if(valToSearch.compareTo(this.val) > 0){
                if(right != null) {                     // right can be null
                    return right.containValueRecursive(valToSearch);
                } else {
                    return false;
                }
            } else {
                if(left != null) {                     // left can be null
                    return left.containValueRecursive(valToSearch);             // recursive approach is better for BTS
                } else {
                    return false;
                }
            }
        }
    }
}

    /*          foo
              /      \
            bar      fox
           /   \     /  \
         abc   baz  for  qwe  */
/* Node<String> wordTree = new Node<>("foo", new Node<>("bar", new Node<>("abc"), new Node<>("baz")), new Node<>("fox", new Node<>("for"), new Node<>("qwe")));*/