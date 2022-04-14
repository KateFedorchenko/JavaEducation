package LeetCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MajorityElementTest {

    public static Stream<Arguments> shouldFindMajorityElement() {
        return Stream.of(
                arguments(new int[]{1,2,3,2},2),
                arguments(new int[]{3,2,3},3),
                arguments(new int[]{2,2,1,1,1,2,2},2),
                arguments(new int[]{4,4,4,1,1,4},4),
                arguments(new int[]{1,2,3,4,5,5,1,1},1),
                arguments(new int[]{1,5,5},5),
                arguments(new int[]{1},1),
                arguments(new int[]{2,2,2,3,3,3,1,2},2)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldFindMajorityElement(int[] nums, int expectedAnswer) {
        int actualAnswer = MajorityElement.findMajorityElement(nums);

        assertEquals(expectedAnswer, actualAnswer);
    }
}