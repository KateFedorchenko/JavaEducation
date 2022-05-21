package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocksDemo {               // useful
    static final List<String> list = new ArrayList<>(List.of("foo", "bar", "qwe", "goo", "fer"));
    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock rLock = lock.readLock();
        Lock wLock = lock.writeLock();
        Runnable reader = () -> {
            while (true) {
                rLock.lock();
                try {
                    if (!list.isEmpty()) {
                        int index = ThreadLocalRandom.current().nextInt(list.size());
                        list.get(index);
                    }
                } finally {
                    rLock.unlock();
                }
            }
        };
        Runnable writer = () -> {
            while (true) {
                String s = String.valueOf(ThreadLocalRandom.current().nextLong());
                wLock.lock();
                try {
                    if (Math.random() > 0.5) {
                        list.add(s);
                    } else {
                        if (!list.isEmpty()) {
                            list.remove(0);
                        }
                    }
                } finally {
                    wLock.unlock();
                }
            }
        };
        executorService.execute(writer);
        executorService.execute(reader);
        executorService.execute(reader);
        executorService.execute(reader);

        executorService.shutdown();

    }
}
