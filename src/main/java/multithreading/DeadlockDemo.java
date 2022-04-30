package multithreading;

public class DeadlockDemo {
    public static void main(String[] args)throws Exception {
        //At least we need two locks
        //We take these locks in different order in different threads

        Object m1 = new Object();
        Object m2 = new Object();

        Thread t1 = new Thread(
            new Runnable() {
                @Override public void run() {
                    while (true) {
                        synchronized (m1) {
                            synchronized (m2) {
                                System.out.println("Thread1 is reporting");
                            }
                        }
                    }
                }
            }
        );

        Thread t2 = new Thread(
            new Runnable() {
                @Override public void run() {
                    while (true) {
                        synchronized (m2) {
                            synchronized (m1) {
                                System.out.println("Thread2 is reporting");
                            }
                        }
                    }
                }
            }
        );


        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
