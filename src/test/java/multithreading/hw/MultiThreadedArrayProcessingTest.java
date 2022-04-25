//package multithreading.hw;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.params.provider.Arguments.arguments;
//
//class MultiThreadedArrayProcessingTest {
//
//    public static Stream<Arguments> shouldFindLargestElementIndexMultiThreaded(){
//        return Stream.of(
//                arguments(new int[]{1,2,3,2},2),
//                arguments(new int[]{-1,2,3,-2},2),
//                arguments(new int[]{1868,2686,38688,-2},2),
//                arguments(new int[]{1},0),
//                arguments(new int[]{3,2,3},0)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    public void shouldFindLargestElementIndexMultiThreaded(int[] arr, int expectedAnswer){
//        int actualAnswer = MultiThreadedArrayProcessing.findLargestElementIndexMultiThreaded(arr);
//
//        assertEquals(expectedAnswer,actualAnswer);
//    }
//
//}