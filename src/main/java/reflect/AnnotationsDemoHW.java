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

    @AllArgsConstructor
    static class FourthData {
        int[] x;
    }

    public static void main(String[] args) {
        FirstData object1 = new FirstData(2,"basket");
        FirstData object2 = new FirstData(234,"bloopers");
        SecondData object3 = new SecondData(2,"basket");
        ThirdData object4 = new ThirdData("basket", 2,3);
        FourthData obj1 = new FourthData(new int[]{1,2});
        FourthData obj2 = new FourthData(new int[]{1,2});
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,3};
        System.out.println(ReflectionUtils.equals(obj1,obj2));
//        System.out.println("FirstData = " + ReflectionUtils.toString(object1));
//        System.out.println("SecondData = " + ReflectionUtils.toString(object3));
//        System.out.println(ReflectionUtils.equals(object1,object2));             // true
//        System.out.println(ReflectionUtils.equals(null,object2));            // false
//        System.out.println(ReflectionUtils.equals(object1,object3));             // false
//        System.out.println(ReflectionUtils.equals(null,null));           // true
//        System.out.println(ReflectionUtils.equals(object1,object4));             // false
    }
}
