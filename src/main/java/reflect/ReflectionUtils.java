package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ReflectionUtils {

    public static String toString(Object o) {
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        try {
            for (Field declaredField : declaredFields) {
                sb.append(declaredField.getName()).append(" = ").append(declaredField.get(o)).append(", ");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }

    /**
     * Compares two Objects based on the following principals:
     * 1) both Objects come from the same class OR
     * 2) both Objects come from different classes, but they have the fields of the same types (and values)
     * which are put in the same order. The names of fields to be ignored.
     *
     * @param lhs - left Object
     * @param rhs - right Object
     * @return true if the Objects equal to each other, otherwise false.
     */
    public static boolean equals(Object lhs, Object rhs) {
        if (lhs == null && rhs == null) {
            return true;
        }
        if (lhs == null || rhs == null) {
            return false;
        }
        if (lhs.getClass() == rhs.getClass()) {
            if (lhs.getClass().isArray()) {
                int lhsSize = Array.getLength(lhs);
                int rhsSize = Array.getLength(rhs);
                if (lhsSize != rhsSize) {
                    return false;
                }
                for (int i = 0; i < lhsSize; i++) {
                    if (!ReflectionUtils.equals(Array.get(lhs, i), Array.get(rhs, i))) {     //null.equals() -> NullPointerExc
                        return false;
                    }
                }
                return true;
            }
            return lhs.equals(rhs);
        }
        Class<?> lhsClass = lhs.getClass();
        Field[] lFields = lhsClass.getDeclaredFields();
        Class<?> rhsClass = rhs.getClass();
        Field[] rFields = rhsClass.getDeclaredFields();
        if (rFields.length != lFields.length) {
            return false;
        }
        try {
            for (int i = 0; i < lFields.length; i++) {
                if (lFields[i].getType() != rFields[i].getType()) {
                    return false;
                }
            }
            for (int i = 0; i < lFields.length; i++) {
                if (!lFields[i].get(lhs).equals(rFields[i].get(rhs))) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
