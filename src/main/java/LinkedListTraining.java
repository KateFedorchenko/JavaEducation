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
    public static Node createList(String... values) {
        if(values.length == 0){
            return null;
        }
        Node head = new Node(null,null);
        Node node = new Node(null,null);
        for(int i = 0; i<values.length; i++) {
             if(i == 0){
                head = new Node(values[0],null);
                //head.next = new Node(values[i+1],null);
            } else {
                node = new Node(values[i],null);
                node.next = new Node(values[i+1],null);
                i++;
            }
        }
        return head;                       // how to create a new node every time without changing the name of variable Node???
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
}
