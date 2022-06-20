package reflect;

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
     * 2) both Objects come from different classes, but they have the fields of the same types (and values) which are put in the same order. The names of fields to be ignored.
     *
     * @param lhs - left Object
     * @param rhs - right Object
     * @return true if the Objects equal to each other, otherwise false.
     */
    public static boolean equals(Object lhs, Object rhs) {
        if (lhs == null && rhs == null) {
            return true;
        }
        if(lhs == null || rhs == null){
            return false;
        }
        if (lhs.getClass() == rhs.getClass()) {
            return true;
        }
        Class<?> lhsClass = lhs.getClass();
        Field[] declaredFieldsLhs = lhsClass.getDeclaredFields();
        Class<?> rhsClass = rhs.getClass();
        Field[] declaredFieldsRhs = rhsClass.getDeclaredFields();
        if (declaredFieldsRhs.length != declaredFieldsLhs.length) {
            return false;
        }
        try {
            for (int i = 0; i < declaredFieldsLhs.length; i++) {
                for (int j = 0; j < declaredFieldsRhs.length; j++) {
                    if(!declaredFieldsLhs[i].get(lhs).equals(declaredFieldsRhs[i].get(rhs))){
                        return false;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
