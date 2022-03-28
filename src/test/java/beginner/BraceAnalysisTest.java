package beginner;

import collections.problem.BraceAnalysis;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BraceAnalysisTest {

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
        String str = "([{]})";
    }


    public static Stream<Arguments> isCorrectModification() {
        return Stream.of(
            of("([{]})", false),
            of("([{[]})", false),
            of("([{}])", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldFindSum() {
        int[] res = BraceAnalysis.isCorrectModification(str);

    }
}
