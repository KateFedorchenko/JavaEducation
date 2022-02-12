package beginner;

public class ExceptionsDemo2 {
    static long counter = 0;
    public static void main(String[] args) {
        System.out.println(fib(-1));

    }

    public static long fib(int x) {
        if(x > 45) {
            throw new IllegalArgumentException("The function is not supposed to compute fib number above 45");
        }
        if(x < 0) {
            throw new IllegalArgumentException("Please provide non-negative param");
        }
        if(x == 0) {
            return 0;
        }
        if(x == 1 || x == 2) {
            return 1;
        }
        return fib(x-1)+fib(x-2);
    }
}
