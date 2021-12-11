public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        for (int i = 1; i < 5; i++) {
            queue.push(i);
        }
        System.out.println("queue.remove() = " + queue.remove());

    }
}
