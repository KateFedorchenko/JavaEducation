package reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;

public class AnnotationsDemo {
    @Getter
    @AllArgsConstructor
    static class MyData {
        @Setter
        private int x;
        private String str;


    }

    @AllArgsConstructor
    static class AlsoData {
        private int s;
        private String string;
        @ToString(name = "Char field")
        private char c;
        @ToString
        private LocalDate date;


        @Override
        public String toString() {
            Class<?> clazz = this.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            try {
                for (Field df : declaredFields) {
                    if (df.isAnnotationPresent(ToString.class)) {
                        ToString anno = df.getAnnotation(ToString.class);
                        String fieldName;
                        if(anno.name().equals("")){
                            fieldName = df.getName();
                        } else {
                            fieldName = anno.name();
                        }
//                        df.setAccessible(true);       // breaks
                        sb.append(fieldName).append(" = ").append(df.get(this)).append(", ");
                    }
                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append("}");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return sb.toString();
        }
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    static @interface ToString {
        String name() default "";       // annotation field


    }

    public static void main(String[] args) {
        AlsoData ad = new AlsoData(3, "foo", 'd', LocalDate.now());
        System.out.println(ad);

    }

}

// reflection utils - class name. ToString() -> function
// method public static boolean equals(Object lhs, Object rhs){
// should compare ?? }