public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pop();
        stack.push("foo");
        stack.push("bar");
        for(int i =0; i<20;i++) {
            stack.push(String.valueOf(i));
        }
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        stack.pop();
    }
}