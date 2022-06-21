package reflect;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@AnnotationDemo2.MyTypeAnnotation
public class AnnotationDemo2 {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnos {
        MyAnno[] value();
    }

    @Repeatable(MyAnnos.class)
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnno {
        String[] value();
        int foo() default 42;
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTypeAnnotation{
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyParameterAnnotation{
    }

    @Target(ElementType.TYPE_PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTypeParameterAnnotation{
    }

    @Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyUseTypeAnnotation{
    }

    @MyAnno(value = "foo", foo = 42)
    @MyAnno("foo")
//    @MyAnno(value = {"foo","bar"})
//    @MyAnnos({@MyAnno("foo"),@MyAnno("bar")})
    public static void main(@MyParameterAnnotation String[] args) throws Exception{
        Method main = AnnotationDemo2.class.getDeclaredMethod("main", String[].class);
        Parameter[] parameters = main.getParameters();
        System.out.println(Arrays.toString(main.getAnnotations()));
//        for (Parameter p : parameters) {
//            System.out.println(Arrays.toString(p.getAnnotations()));
//        }
        List<@MyUseTypeAnnotation String> list = new ArrayList<>();
    }

    public static class MyData<@MyTypeParameterAnnotation T>{}
}
