public class StackDemo {
    public static void main(String[] args) {
        /*Stack stack = new Stack();
        stack.pop();
        stack.push("foo");
        stack.push("bar");
        for(int i =0; i<20;i++) {
            stack.push(String.valueOf(i));
        }
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        stack.pop();*/
        Stack stack = new Stack(10);
        for(int i = 1; i < 6; i++) {
            stack.push(i);
        }
        stack.pop();
    }
}
