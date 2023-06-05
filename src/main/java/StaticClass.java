import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaticClass {
    static class Inner{}    //like independent class

    class InnerSecond{}     // depends on StaticClass strongly

    @Getter
    @ToString
    @AllArgsConstructor
    static class Person{
        private String name;
        private int height;
        private LocalDate birthday;
        @Getter(AccessLevel.NONE)
        private List<String> hobbies;

        public List<String> getHobbies(){
            return new ArrayList<>(hobbies);
        }
    }

    public static void main(String[] args) {

//        String str = new String();
////        Inner inner = new Inner();
////
////        InnerSecond innerSecond = new StaticClass().new InnerSecond();
//        Person person = new Person("Nick", 167,LocalDate.of(1995,1,1), List.of("v","f"));
//        person.getHobbies().add("e");

//        String s1 = "foo";
//        String s2 = "foo";
//        String s3 = new String("foo");
//        String s4 = s3.intern();
//        String s5 = "fo" + "o";
//
//        System.out.println("s1 == s2 = " + (s1 == s2));
//        System.out.println("s1 == s3 = " + (s1 == s3));
//        System.out.println("s1 == s4 = " + (s1 == s4));
//        System.out.println("s1 == s5 = " + (s1 == s5));

        String s1 = "Aa";
        String s2 = "BB";

        System.out.println("s1.hashCode() == s2.hashCode() = " + (s1.hashCode() == s2.hashCode()));
        //what can be


    }
}
