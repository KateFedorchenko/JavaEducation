package utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;

public class ListArgumentConverter implements ArgumentConverter {
    private final DefaultArgumentConverter defaultArgumentConverter = DefaultArgumentConverter.INSTANCE;


    @Override public List<?> convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source == null) {
            return null;
        }

        if (!context.getParameter().getType().isAssignableFrom(List.class)) {
            throw new IllegalArgumentException("Expected List parameter but got " + context.getParameter().getType());
        }

        ParameterizedType type = (ParameterizedType) context.getParameter().getParameterizedType();

        Class<?> elementType = (Class<?>) type.getActualTypeArguments()[0];

        if (!(source instanceof String s) || !s.startsWith("[") || !s.endsWith("]")) {
            throw new IllegalArgumentException("Wrong csv format expected list with format [1,2,3] but got " + source);
        }

        List<Object> res = new ArrayList<>();

        int st = 1; // index of symbol after '['
        int end = s.indexOf(',');
        for (; end != -1 && end <= s.length(); ) {
            String obj = s.substring(st, end).trim();
            res.add(defaultArgumentConverter.convert(obj, elementType));

            st = end + 1;
            end = s.indexOf(',', st);
        }

        String obj = s.substring(st, s.length() - 1).trim();

        if (obj.length() != 0) {
            res.add(defaultArgumentConverter.convert(obj, elementType));
        }

        return res;
    }
}
