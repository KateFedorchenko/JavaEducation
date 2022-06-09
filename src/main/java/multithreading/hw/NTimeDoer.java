package multithreading.hw;

import java.util.concurrent.atomic.AtomicInteger;


public class NTimeDoer {
    AtomicInteger counter = new AtomicInteger(0);
    Runnable r;
    int n;

    public NTimeDoer(int n, Runnable r) throws RuntimeException {
        if (n <= 0) {
            throw new RuntimeException("n cannot be less than 0");
        }
        this.n = n;
        this.r = r;
    }

    public void doIt() {
        int i;
        do {
            i = counter.get();
            if (i < n && counter.compareAndSet(i, i + 1)) {  // the best atomic method
                r.run();//throws Exception
                break;
                
            }
        } while (i < n);
    }
}


