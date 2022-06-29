package reflect;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {
    @ParameterizedTest
    @MethodSource("dataGenerator")
        // actually value = "dataGenerator"
    void test(Object lhs, Object rhs, boolean expected) {
        boolean actual = ReflectionUtils.equals(lhs, rhs);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> dataGenerator() {
        @AllArgsConstructor
        class FirstData {
            int x;
            String str;
        }

        @AllArgsConstructor
        class SecondData {
            int x;
            String str;
        }

        @AllArgsConstructor
        class ThirdData {
            String str;
            int x;
            int z;
        }

        @AllArgsConstructor
        class FourthData {
            int[] arr;
            String str;
        }

        @AllArgsConstructor
        class FifthData {
            int[] arr;
        }

        return Stream.of(
                Arguments.of("foo", "foo", true),
                Arguments.of("foo", "bar", false),
                Arguments.of(null, null, true),
                Arguments.of(null, "foo", false),
                Arguments.of("bar", null, false),
                Arguments.of("12", 12, false),
                Arguments.of("bar", 12, false),
                Arguments.of(12, 12, true),
                Arguments.of(12.01, 12, false),
                Arguments.of(new int[]{1}, 1, false),
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,3}, true),
                Arguments.of(new int[][]{{1},{1,2,3}}, new int[][]{{1},{1,2,3}}, true),
                Arguments.of(new int[]{0}, new int[]{0,0}, false),
                Arguments.of(new String[]{"foo"}, new String[]{"foo"}, true),
                Arguments.of(new String[]{"foo","bar"}, new String[]{"bar","foo"}, false),
                Arguments.of(new String[]{"a","b"}, new String[]{"a","b","c"}, false),
                Arguments.of(new String[]{"a","b",null}, new String[]{"a","b","c"}, false),
                Arguments.of(new String[]{null}, new String[]{null}, true),
                Arguments.of(new FirstData(2, "basket"), new FirstData(2, "bloopers"), false),
                Arguments.of(new SecondData(2, "basket"), new FirstData(2, "basket"), true),
                Arguments.of(new ThirdData("basket", 2, 3), new FirstData(2, "basket"), false),
                Arguments.of(new FourthData(new int[]{1,2,3}, "data"), new FourthData(new int[]{1,2,3}, "data"), true),
                Arguments.of(new FourthData(new int[]{1,2,3}, "data"), new FifthData(new int[]{1,2,3}), false)
        );
    }
}

// to be done with all tests from Main
// array - does not work!!! SPECIAL --> HW