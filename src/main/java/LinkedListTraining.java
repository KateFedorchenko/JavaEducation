public class LinkedListTraining {

    private static class Node {
        String val;
        Node next;

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(){

        }

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
        splice(headList,tailList);                                 // no use as "headList.splice(headList,tailList)" - why?
        System.out.println(headList); // Node can be printed!

        // Example of LinkedList creation
        createList("foo", "qwe", "bar", "test");

    }

    /**
     * Creates linked list from given values.
     * Example:
     * {@code createList("foo", "qwe", "bar", "test") yields <foo> -> <qwe> -> <bar> -> <test> -> null}
     * @param values Vararg of values. It is essentially String[] in the terms of usage in function.
     * @return Reference to the head node of newly created linked list
     */
    public static Node createList(String... values) {                           // a bit strange - did not know this --> "String... values"
        Node head = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node tail = new Node();
        for(int i = 0; i<values.length; i++) {
             if(i == 0) {
                head.val = values[i];
            } else if(i == 1) {
                node2.val = values[i];
            } else if(i == 2) {
                node3.val = values[i];
            } else if(i == 3) {
                tail.val = values[i];
            }
        }
        head.next = node2;
        node2.next = node3;
        node3.next = tail;
        return head;
    }


    /**
     * Concatenates two linked list with each other.
     *
     * @param headList Head part of the resulting list.
     * @param tailList Tail part of the resulting list.
     */
    public static void splice(Node headList, Node tailList) {
        headList.next = tailList;
        tailList= null;                      // seems like not ok
    }
}
