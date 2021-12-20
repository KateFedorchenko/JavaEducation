public class LinkedListTraining {

    private static class Node {
        String val;
        Node next;

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        /*public Node(){

        }*/

        @Override public String toString() {
            Node cur = this;
            StringBuilder sb  = new StringBuilder();
            while(cur != null) {
                sb.append("{\"").append(cur.val).append("\"}").append(" -> ");
                cur = cur.next;
            }
            sb.append("null");

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Example of concatenation
        Node headList = new Node("first",null);
        Node tailList = new Node("second",null);
        splice(headList,tailList);                                 // what "free function." means?
        System.out.println(headList); // Node can be printed!

        // Example of LinkedList creation
        createList("foo", "qwe", "bar", "test","a","b","c","d","e");

    }

    /**
     * Creates linked list from given values.
     * Example:
     * {@code createList("foo", "qwe", "bar", "test") yields <foo> -> <qwe> -> <bar> -> <test> -> null}
     * @param values Vararg of values. It is essentially String[] in the terms of usage in function.
     * @return Reference to the head node of newly created linked list
     */
    public static Node createList(String... values) {
        Node node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new Node(values[i],node);
            System.out.println(node);
        }
        return node;
//        Node head = null;
//        Node node;
//        for (int i = 0; i < values.length; i++) {
//            node = new Node(values[i],null);
//            if(head == null) {
//                head = node;
//            }
//        }
//        return head;
                             // how to create a new node every time without changing the name of variable Node???
    }


    /**
     * Concatenates two linked list with each other.
     *
     * @param headList Head part of the resulting list.
     * @param tailList Tail part of the resulting list.
     */
    public static void splice(Node headList, Node tailList) {
        headList.next = tailList;
        tailList= null;
    }

    /**
     * Checks whether given list contains specified value.
     *
     * @param listHead Head of linked list.
     * @param value Value to search.
     * @return {@code True} if list contain value, {@code false} otherwise.
     */
    public static boolean listContainsValue(Node listHead, String value) {
        return false;
    }

    /**
     * Reverses given linked list.
     * TRY TO IMPLEMENT with O(1) memory!
     * e.g.
     * 1->2->3->4->null
     *   converts to
     * 4->3->2->1->null
     *
     * @param listHead Head of linked list.
     * @return Head of reversed linked list.
     */
    public static Node reverseList(Node listHead) {
        return null;
    }
}
