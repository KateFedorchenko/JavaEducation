package reflect;

import lombok.AllArgsConstructor;

public class AnnotationsDemoHW {
    @AllArgsConstructor
    static class FirstData {
        int x;
        String str;
    }

    @AllArgsConstructor
    static class SecondData {
        int x;
        String str;
    }

    @AllArgsConstructor
    static class ThirdData {
        String str;
        int x;
        int z;
    }

    public static void main(String[] args) {
        FirstData object1 = new FirstData(2,"baskett");
        FirstData object2 = new FirstData(234,"bloopers");
        SecondData object3 = new SecondData(2,"basket");
        ThirdData object4 = new ThirdData("basket", 2,3);
        System.out.println("FirstData = " + ReflectionUtils.toString(object1));
        System.out.println("SecondData = " + ReflectionUtils.toString(object3));
        System.out.println(ReflectionUtils.equals(object1,object2));             // true
        System.out.println(ReflectionUtils.equals(null,object2));            // false
        System.out.println(ReflectionUtils.equals(object1,object3));             // false
        System.out.println(ReflectionUtils.equals(null,null));           // true
        System.out.println(ReflectionUtils.equals(object1,object4));             // false
    }
}
