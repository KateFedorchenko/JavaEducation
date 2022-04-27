package multithreading.hw;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static multithreading.hw.MultiThreadedArrayProcessing.findLargestElementIndexMultiThreaded;
import static multithreading.hw.MultiThreadedArrayProcessing.generateArray;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MultiThreadedArrayProcessingTest {

    public static Stream<Arguments> shouldFindLargestElementIndexMultiThreaded(){
        return Stream.of(
                arguments(new int[]{1,2,3,2},2),
                arguments(new int[]{-1,2,3,-2},2),
                arguments(new int[]{1868,2686,38688,-2},2),
                arguments(new int[]{1},0),
                arguments(new int[]{3,2,3},0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldFindLargestElementIndexMultiThreaded(int[] arr, int expectedAnswer) throws  Exception{
        int actualAnswer = findLargestElementIndexMultiThreaded(arr,Runtime.getRuntime().availableProcessors());

        assertEquals(expectedAnswer,actualAnswer);
    }

    @RepeatedTest(5)
    public void shouldFindLargestElementWithGeneratedArray() throws Exception {
        int[] arr = generateArray(100000);
        int actualAnswer = findLargestElementIndexMultiThreaded(arr,Runtime.getRuntime().availableProcessors());

        int maxVal = arr[actualAnswer];
        Arrays.sort(arr);
        assertEquals(arr[arr.length-1], maxVal);
    }

}