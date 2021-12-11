public class Queue2 {
    private Node head;

    private static class Node{
        int val;
        Node next;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public void push(int val){
        if(head == null) {
            Node node = new Node(val,null);
            head = node;
        } else {
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            //теперь cur указывает на последний элемент списка
            Node node = new Node(val,null);
            cur.next = node;
        }
    }
}
