package multithreading;

public class SynchronizeMiscUsageDemo {
    static class DataAccessor<T> {
        T data;

//        public void set(T newData) {
//            synchronized (this) {
//                data = newData;
//            }
//        }

        public synchronized void set(T newData) {
            data = newData;
        }

//        public T get() {
//            synchronized (this) {
//                return data;
//            }
//        }

        public synchronized T get() {
            return data;
        }


        /*
        public static <T> DataAccessor<T> getInstance() {
            synchronized(DataAccessor.class) {
                return new DataAccessor<>();
            }
        }
         */

        public static synchronized <T> DataAccessor<T> getInstance() {// who is the mister mutex? DataAccessor.class
            return new DataAccessor<>();
        }
    }


    public static void main(String[] args) {
    }
}
