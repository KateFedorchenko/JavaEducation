package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;

public class SimpleClassIntrospectionDemo {
    static class MyData {
        int count;
        String str;
        LocalDate date;

        public MyData(int count, String str, LocalDate date) {
            this.count = count;
            this.str = str;
            this.date = date;
        }

        @Override
        public String toString() {
            return getStringRVersion2(this);
        }
    }

    public static void main(String[] args) throws Exception {
//        MyData myData = new MyData(42,"foo",LocalDate.of(2022, Month.FEBRUARY,2));
//        System.out.println(myData.toString());
        MyData md = new MyData(2,"boolean",LocalDate.of(2032, Month.MARCH,23));
        System.out.println(md.toString());
    }

    /**
     * If type of field is primitive, then value to be printed as is.
     * If type of field is java.lang.String, then value to be printed 'foo'.
     * If other Object types, then value to be printed as prefix of this type and value in quotes.
     *
     * @param o
     * @return {count = 42, str = 'foo', date = java.time.LocalDate'2022-12-12'}
     * @throws Exception
     */
    public static String getStringRVersion2(Object o) {
        Class<?> clazz = o.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        try {
            for (Field declaredField : declaredFields) {
                sb.append(declaredField.getName()).append(" = ");
                Class<?> type = declaredField.getType();
                if (type.isPrimitive()){
                    sb.append(declaredField.get(o));
                } else if(type.equals(String.class)){
                    sb.append("'").append(declaredField.get(o)).append("'");
                } else {
                    sb.append(type.getName()).append("'").append(declaredField.get(o)).append("'");
                }
                sb.append(", ");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }


    /**
     * MyData
     *
     * @param o
     * @return {count = 42, str = foo, date = 2022-12-12}
     */
    public static String getStringRepresentation(Object o) {
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();            // fields are declared in that class
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        try {
            for (Field declaredField : declaredFields) {
                sb.append(declaredField.getName()).append(" = ").append(declaredField.get(o)).append(", ");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        sb.delete(sb.length() - 2, sb.length());       // open 'end' interval
        sb.append("}");
        return sb.toString();
    }


    public static void doIt() {
        System.out.println("do");
    }

    public static void doRes() {
        System.out.println("dohh");
    }

    public static void declaredMethods() throws Exception {
        Class<?> aClazz = SimpleClassIntrospectionDemo.class;   //.class (like an entity) -> everything has it
        Method[] declaredMethods = aClazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            if (declaredMethods[i].getName().startsWith("do")) {
                declaredMethods[i].invoke(null);
            }
            System.out.println(declaredMethods[i]);
        }
    }
}
