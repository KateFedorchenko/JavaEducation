package multithreading.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeMap<K, V> {
    Map<K, V> threadSafeMap;
    ReadWriteLock globalLock = new ReentrantReadWriteLock();

    public ThreadSafeMap() {
        threadSafeMap = new HashMap<>();
    }

    public V put(K key, V value) {
        globalLock.writeLock().lock();
        try {
            return threadSafeMap.put(key, value);
        } finally {
            globalLock.writeLock().unlock();
        }
    }

    public V get(Object key) {
        globalLock.readLock().lock();
        try {
            return threadSafeMap.get(key);
        } finally {
            globalLock.readLock().unlock();
        }
    }

    public int size() {
        globalLock.readLock().lock();
        try {
            return threadSafeMap.size();
        } finally {
            globalLock.readLock().unlock();
        }
    }

    public V replace(K key, V value) {
        globalLock.writeLock().lock();
        try {
            return threadSafeMap.replace(key, value);
        } finally {
            globalLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable r = () -> {
            ThreadSafeMap<Integer,String> map = new ThreadSafeMap<>();
            map.put(0,"f");
            map.put(1,"ff");
            map.put(2,"fff");
            map.put(3,"ffff");
            System.out.println("map.get(0) = " + map.get(0));
            System.out.println("map.size() = " + map.size());
            System.out.println("map.replace(2,\"bbb\") = " + map.replace(2, "bbb"));
            System.out.println("map.get(2) = " + map.get(2));
        };
        executorService.execute(r);
        executorService.shutdown();
    }
}
