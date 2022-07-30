package java8;


import java.util.Optional;

public class OptionalDemo {
    public static String getMessage() {
        if (Math.random() > 0.5) {
            return "foo";
        } else {
            return null;
        }
    }

    public static Optional<String> getMessageOpt() {
        if (Math.random() > 0.5) {
            return Optional.of("foo");
        } else {
            return Optional.empty();// if the function returns Optional - no 'null' can be returned !!
        }
    }

    public static void main(String[] args) {
        Optional<String> optStr = Optional.empty();//Optional = container for a single element or no element => 1 || 0
        String message = getMessage();
        if (message != null) {
            System.out.println("Your message is " + message);
        } else {
            System.out.println("There's no message");
        }

        Optional<String> messageOpt = getMessageOpt();
        if (!messageOpt.isEmpty()) {    // isPresent()
            System.out.println("Your message is " + messageOpt.get());
        } else {
            System.out.println("There's no message");
        }

        messageOpt.ifPresent(m -> System.out.println("Your message is " + m));

        String s = messageOpt.map(m -> "Your message is " + m).orElse("There's no message");// map returns a new optional
        printTempInfo2(Optional.ofNullable(null));




    }

    public static void printTempInfo(Optional<Integer> tempInK){
        int c;
        if(tempInK.isPresent()){
            c = tempInK.get() - 273;
            System.out.println("The temp is " + c);
        } else {
            System.out.println("Cannot be converted to C");
        }
    }

    public static void printTempInfo2(Optional<Integer> tempInK){
        String message = tempInK.map(k -> k - 273).map(c -> "The temp is " + c + "C").orElse("No temp");
        System.out.println(message);

    }
}
