package reflect.HW;

import LeetCode.MajorityElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayCopyTest {
//    @ParameterizedTest
//    @MethodSource
//    public void shouldCopyIntegerArray(int[] object, int[] expectedAnswer) {
//        int[] actualAnswer = ArrayCopy.copy(object);
//        assertEquals(expectedAnswer, actualAnswer);
//    }

    @ParameterizedTest
    @MethodSource
    public void shouldCopyStringArray(String[] object, String[] expectedAnswer) {
        String[] actualAnswer = ArrayCopy.copy(object);
        assertEquals(expectedAnswer, actualAnswer);
    }

    public static Stream<Arguments> shouldCopyStringArray() {
        return Stream.of(
                arguments(new String[]{"foo","bar"},new String[]{"foo","bar"})
        );
    }

    public static Stream<Arguments> shouldCopyIntegerArray() {
        return Stream.of(
                arguments(new int[]{1,2},new int[]{1,2})
        );
    }


}