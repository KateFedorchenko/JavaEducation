public class LinkedListTraining {

    private static class Node {
        String val;
        Node next;

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
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
        //test your code here

        Node n = new Node("foo", new Node("bar", null));

        System.out.println(n); // Node can be printed!
    }

    /**
     * Creates linked list from given values.
     * Example:
     * {@code createList("foo", "qwe", "bar", "test") yields <foo> -> <qwe> -> <bar> -> <test> -> null}
     * @param values Vararg of values. It is essentially String[] in the terms of usage in function.
     * @return Reference to the head node of newly created linked list
     */
    public static Node createList(String... values) {

        return new Node("foo", null);
    }

    /**
     * Concatenates two linked list with each other.
     *
     * @param headList Head part of the resulting list.
     * @param tailList Tail part of the resulting list.
     */
    public static void splice(Node headList, Node tailList) {

    }
}
