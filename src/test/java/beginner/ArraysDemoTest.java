package beginner;

import java.util.Arrays;
import java.util.stream.Stream;

import beginner.ArraysDemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class ArraysDemoTest {

    public static Stream<Arguments> shouldGetMinValue() {
        return Stream.of(
            of(new int[]{1}, 1),
            of(new int[]{42,48, -100}, -100),
            of(new int[]{10, 10}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldGetMinValue(int[] arr, int minVal) {
        assertEquals(ArraysDemo.getMinValue(arr), minVal);
    }

    @Test
    public void shouldNotMutateArray() {
        int[] ints = {42, 2, 3, 1};
        int[] copy = Arrays.copyOf(ints, ints.length);

        ArraysDemo.getMinValue(copy);

        assertArrayEquals(ints, copy);
    }


    public static Stream<Arguments> shouldFindSum() {
        return Stream.of(
            of(new int[]{1}, 1, null),
            of(new int[]{1,2}, 3, new int[]{0,1}),
            of(new int[]{1,2}, 2, null),
            of(new int[0], 1, null),
            of(null, 1, null),
            of(new int[]{42,42}, 42, null),
            of(new int[]{42,42}, 84, new int[]{0,1}),
            of(new int[]{0,2,1,3,1}, 3, new int[]{0,3})//not {1,2}!!
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldFindSum(int[] arr, int sum, int[] expected) {
        int[] res = ArraysDemo.findExactSumOfTwoElements(arr, sum);

        assertArrayEquals(expected, res);
    }
}
