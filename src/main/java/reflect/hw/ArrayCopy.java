package reflect.hw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopy {
    public static <T> T[] copy(T[] object) {
//        Class<?> claz = object.getClass();
        Class<?> sourceArrType = object.getClass().getComponentType();
        T[] copy = (T[]) Array.newInstance(sourceArrType, object.length);

         //To replace with cycle.

        System.arraycopy(object, 0, copy, 0, object.length);
        return copy;
    }

    public static void main(String[] args) {
        Object o = new String("foo");
        String o2 = (String) o;

        String[][] arr = {{"foo"},{"bar"}};
        String[][] arr2 = copy(arr);
        arr[0][0] = "xyz";
        System.out.println(arr2[0][0]);
    }
}

