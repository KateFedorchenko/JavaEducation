public class QueueDemo {
    public static void main(String[] args) {
        Queue2 queue = new Queue2();
        queue.push(42);
        queue.push(0);
        queue.push(12);
        System.out.println();
        for(int i = 0; i<4; i++) {
            System.out.println("queue.remove() = " + queue.remove());
        }



    }
}
