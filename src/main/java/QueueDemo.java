public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        for (int i = 1; i < 6; i++) {
            queue.push(i);
        }
        queue.remove();
    }
}
