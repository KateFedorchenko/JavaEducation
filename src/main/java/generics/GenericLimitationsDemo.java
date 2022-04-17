package generics;

public class GenericLimitationsDemo {
    //public static MyException<T> extends Exception {}


    /*
    //Can't create array of genericType!
    public static <T> T[] generateArray(int size) {
        return new T[size];
    }
     */

    /* Can't instantiate generic type.
    public static <T> T generateOne() {
        return new T();
    }
     */

    public static void print(Integer x) {
        System.out.println("Integer: " + x);
    }

    /* CE have same erasure with next method (see bytecode for additional insights)
    public static <T> void print(T x) {
        System.out.println("Generic: " + x);
    }
     */

    public static void print(Object x) {
        System.out.println("Object: " + x);
    }

    public static void main(String[] args) {
        print(1);
    }
}
