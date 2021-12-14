import java.util.stream.IntStream;

public class QueueDemo {
    public static void main(String[] args) {
        int size = 200_000;

        Queue2 q2 = new Queue2();
        Queue q1 = new Queue(size);

        measureRunTime(
            "Array queue",
            () -> IntStream.range(0, size).forEach(i -> q1.push(i))
        );

        measureRunTime(
            "LinkedList queue",
            () -> IntStream.range(0, size).forEach(i -> q2.push(i))
        );

        measureRunTime(
            "Array queue remove",
            () -> IntStream.range(0, size / 2).forEach(i -> q1.remove())
        );

        measureRunTime(
            "LinkedList queue remove",
            () -> IntStream.range(0, size / 2).forEach(i -> q2.remove())
        );
    }

    private static void measureRunTime(String runnableName, Runnable runnable) {
        long currentTime = System.currentTimeMillis();// UNIX EPOCH

        runnable.run();

        System.out.println("Runnable " + runnableName + " took " + (System.currentTimeMillis() - currentTime) + " ms.");

    }

}
