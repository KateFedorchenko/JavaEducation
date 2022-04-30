package multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerDemo {

    static class MyList {
        private int size;

        public int getSize() {
            return size;
        }
    }

    static class DataHolder {
        Long data;

        public DataHolder(Long data) {
            this.data = data;
        }
    }

    static class Producer implements Runnable {
        DataHolder dataHolder;
        @Override public void run() {
            while(true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (dataHolder) {
                    if (dataHolder.data == null) {
                        dataHolder.data = ThreadLocalRandom.current().nextLong();
                        dataHolder.notifyAll();
                    }
                }
            }
        }

        public Producer(DataHolder dataHolder) {
            this.dataHolder = dataHolder;
        }
    }

    static class Consumer implements Runnable {
        DataHolder dataHolder;
        @Override public void run() {
            int i = 0;
            while (true) {
                if (i++ % 500_000 == 0) System.out.print("*");

                try {
                    synchronized (dataHolder) {
                        if (dataHolder.data != null) {
                            System.out.println("dataHolder.data = " + dataHolder.data);
                            dataHolder.data = null;
                        } else {
                            dataHolder.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            /* Probably equivalent of code above ^
            if (dataHolder.data != null) {
                System.out.println("dataHolder.data = " + dataHolder.data);
                dataHolder.data = null;
            }
            while (true);
             */
        }

        public Consumer(DataHolder dataHolder) {
            this.dataHolder = dataHolder;
        }
    }

    public static void main(String[] args) throws Exception {
        DataHolder dataHolder = new DataHolder(null);
        Thread t1 = new Thread(new Producer(dataHolder));

        Thread t2 = new Thread(new Consumer(dataHolder));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
