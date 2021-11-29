import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArraysAdvancedDemoTest {

    public static Stream<Arguments> testFindSingleNumber() {
        return Stream.of(
            arguments(new int[] {2,2,1}, 1),
            arguments(new int[] {0}, 0),
            arguments(new int[] {1}, 1),
            arguments(new int[] {1,2,3,2,3}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testFindSingleNumber(int[] arr, int expected) {
        int actual = ArraysAdvancedDemo.findSingleNumber(arr);

        assertEquals(expected, actual);
    }

}