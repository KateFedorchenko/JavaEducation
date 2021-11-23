import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Arrays2DTest {

    public static Stream<Arguments> testArraySpiralTraverse() {
        return Stream.of(
            arguments(
                new int[][] {{1,2,3},
                             {4,5,6},
                             {7,8,9}},

                new int[] {1,2,3,6,9,8,7,4,5}
            ),

            arguments(
                new int[][] {{1,2,3},
                             {4,5,6}},

                new int[] {1,2,3,6,5,4}
            ),

            arguments(new int[0][0], new int[0]),

            arguments(new int[][] {{42}}, new int[]{42}),

            arguments(
                new int[][] {{ 1, 2, 3, 4, 5},
                             { 6, 7, 8, 9,10},
                             {11,12,13,14,15},
                             {16,17,18,19,20},
                             {21,22,23,24,25}},

                new int[] {1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13}
            )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testArraySpiralTraverse(int[][] arr2d, int[] expected) {
        assertArrayEquals(expected, Arrays2D.arraySpiralTraverse(arr2d));
    }

    public static Stream<Arguments> testArraySnakeTraverse() {
        return Stream.of(
            arguments(
                new int[][] {{1,2,3},
                             {4,5,6},
                             {7,8,9}},

                new int[] {1,2,3,6,5,4,7,8,9}
            ),

            arguments(
                new int[][] {{1,2,3},
                             {4,5,6}},

                new int[] {1,2,3,6,5,4}
            ),

            arguments(new int[0][0], new int[0]),

            arguments(new int[][] {{42}}, new int[]{42}),

            arguments(
                new int[][] {{ 1, 2, 3, 4, 5},
                             { 6, 7, 8, 9,10},
                             {11,12,13,14,15},
                             {16,17,18,19,20},
                             {21,22,23,24,25}},

                new int[] {1,2,3,4,5,10,9,8,7,6,11,12,13,14,15,20,19,18,17,16,21,22,23,24,25}
            )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testArraySnakeTraverse(int[][] arr2d, int[] expected) {
        assertArrayEquals(expected, Arrays2D.arraySnakeTraverse(arr2d));
    }

}