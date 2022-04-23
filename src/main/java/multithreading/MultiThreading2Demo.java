package multithreading;

public class MultiThreading2Demo {
    public static void main(String[] args) throws InterruptedException {
        {
            Thread t = new Thread(new FoundAllPrimeNumbers(1000));

            t.start();

            t.join();
        }

        {
            Thread t = new Thread(new Runnable() {
                @Override public void run() {
                    for (int i = 2; i <= 1000; ++i) {
                        if (isPrime(i)) {
                            System.out.println("Prime number: " + i);
                        }
                    }
                }
            }
            );
        }

        {
            Runnable runnable = new Runnable() {
                @Override public void run() {
                    for (int i = 2; i <= 1000; ++i) {
                        if (isPrime(i)) {
                            System.out.println("Prime number: " + i);
                        }
                    }
                }
            };
            Thread t = new Thread(runnable);
        }

        {
            Thread t = new Thread(
                () -> {
                    for (int i = 2; i <= 1000; ++i) {
                        if (isPrime(i)) {
                            System.out.println("Prime number: " + i);
                        }
                    }
                }
            );
        }
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class FoundAllPrimeNumbers implements Runnable {
        private int limit;

        public FoundAllPrimeNumbers(int limit) {
            this.limit = limit;
        }

        @Override public void run() {
            for (int i = 2; i <= limit; ++i) {
                if (isPrime(i)) {
                    System.out.println("Prime number: " + i);
                }
            }
        }
    }
}
