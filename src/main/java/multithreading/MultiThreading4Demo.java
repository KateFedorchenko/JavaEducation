package multithreading;

public class MultiThreading4Demo {
    private static int x = 0;

    public static void main(String[] args) throws Exception{
        Object mutex = new Object();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
                for (int i = 0; i < 1_000_000; i++) {

                    synchronized (this){
                        x++;
                    }
                }

            }
        };
        Thread t1 = new Thread(r);

        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(x);



    }
}
