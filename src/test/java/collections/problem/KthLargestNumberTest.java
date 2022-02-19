package collections.problem;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class KthLargestNumberTest {

    public static Stream<Arguments> shouldFindKthLargestElement() {
        return Stream.of(
            arguments(List.of(1.0, 2.0, 3.0), 1, 1.0),
            arguments(List.of(3.0, 1.0, 2.0), 1, 1.0),
            arguments(List.of(1.0, 2.0, 3.0), 2, 2.0),
            arguments(List.of(4.0, 1.1, 1.2, 4.5, 2.2, 6.6), 4, 4.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldFindKthLargestElement(List<Double> nums, int k, double expectedAnswer) {
        Double actualAnswer = KthLargestNumber.findKthRankedElement(nums, k);

        assertEquals(expectedAnswer, actualAnswer);
    }

    public static Stream<Arguments> shouldThrowIllegalArgumentException() {
        return Stream.of(
            arguments(List.of(), 1),
            arguments(List.of(1.0, 2.0, 3.0), 4)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldThrowIllegalArgumentException(List<Double> nums, int k) {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> KthLargestNumber.findKthRankedElement(nums, k)
        );
    }
}
