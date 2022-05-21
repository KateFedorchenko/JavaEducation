package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksDemo {
    static ExecutorService executorService = Executors.newFixedThreadPool(4);
    static int i = 0;
    static final int COUNT = 10_000;
    static ReentrantLock globalLock = new ReentrantLock();

    private static void foo(){
        globalLock.lock();
        bar();                  // lock() --> sout --> unlock()
        globalLock.unlock();
//        globalLock.getHoldCount();      // better for debugging
    }

    private static void bar(){
        globalLock.lock();
        System.out.println("locked");
        globalLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ReentrantLock lock = new ReentrantLock(); // bool fair?
        Future<?> f1 = executorService.submit(() -> {
            for (int x = 0; x < COUNT; x++) {
               lock.lock();                    // alike synchronized
                try{
                    i++;
                } finally {
                    lock.unlock();
                }
            }
        });
        Future<?> f2 = executorService.submit(() -> {
            for (int x = 0; x < COUNT; x++) {
                lock.lock();                    // alike synchronized
                try{
                    i--;
                } finally {
                    lock.unlock();
                }
            }
        });
        f1.get();
        f2.get();
        System.out.println(i);
        executorService.shutdown();
//        lock.tryLock();                 // try to lock  ->
//        lock.hasQueuedThreads();        //
    }
}

// class ThreadSafeMap<K,V> --> no Interfaces to implement. To make four methods 1) put() 2) get() 3) size() 4) replace()
// fully safe.
// to use lock() OR synchronized (no diff between writers/readers)
