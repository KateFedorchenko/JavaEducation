import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) throws Exception {
//        foo();
//        long[] arr = new long[Integer.MAX_VALUE - 10];

        A a = new A();
    }

    static int foo()
    {
        return foo();
    }

    static class A{
        private B b = new B();

    }

    static class B{
        private A a = new A();

    }
}


// StackOverFlow error code to be written
//