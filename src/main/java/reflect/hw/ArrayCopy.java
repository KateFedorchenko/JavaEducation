package reflect.hw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopy {
    public static <T> T[] copy(T[] object) {        // how to make it for 2-dim. arrays?
        /**
         * Reflection approach, right?
         */
        Class<?> sourceArrType = object.getClass().getComponentType();
        T[] copy = (T[]) Array.newInstance(sourceArrType, object.length);
        System.arraycopy(object, 0, copy, 0, object.length);
        return copy;

        /**
         * Standard approach, right?
         */
//        T[] newObject = Arrays.copyOf(object,object.length);
//        return newObject;

        /**
         * Deep copy, right?
         */
        //return object.clone();
    }

    public static void main(String[] args) {
        String[] str = {"foo"};
        String[] newStr = copy(str);
        System.out.println("Before -> str = " + Arrays.toString(str));
        str[0] = "bar";
        System.out.println("After -> str = " + Arrays.toString(str));
        System.out.println("newStr = " + Arrays.toString(newStr));

        int[] oldArr = {1,2};
//        int[] newArr = (int[])copy(oldArr);       ????


    }
}

