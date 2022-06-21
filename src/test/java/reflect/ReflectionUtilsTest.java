package reflect;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {
    @ParameterizedTest
    @MethodSource("dataGenerator")
    void test(Object lhs, Object rhs, boolean expected) {
        boolean actual = ReflectionUtils.equals(lhs, rhs);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> dataGenerator() {
        return Stream.of(
                Arguments.of("foo", "foo", true),
                Arguments.of("foo", "bar", false)
        );
    }
}

// to be done with all tests from Main
// array - does not work!!! SPECIAL --> HW