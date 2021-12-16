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
        createList("foo", "qwe", "bar", "test");

    }

    /**
     * Creates linked list from given values.
     * Example:
     * {@code createList("foo", "qwe", "bar", "test") yields <foo> -> <qwe> -> <bar> -> <test> -> null}
     * @param values Vararg of values. It is essentially String[] in the terms of usage in function.
     * @return Reference to the head node of newly created linked list
     */
    public static Node createList(String... values) {                           // help
        Node node;
        for(int i = 0; i<values.length; i++) {
            node = new Node(values[i],new Node(values[i+1],null));
        }
        return new Node(values[0],null);
    }


    /**
     * Concatenates two linked list with each other.
     *
     * @param headList Head part of the resulting list.
     * @param tailList Tail part of the resulting list.
     */
    public static void splice(Node headList, Node tailList) {
        headList.next = tailList;
        tailList= null;                      //  contract btw developers or...?
    }
}
