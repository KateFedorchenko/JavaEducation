package beginner;

import collections.problem.BraceAnalysis;
import collections.problem.TextAnalysis;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BraceAnalysisTest {
    public static Stream<Arguments> shouldGetMinValue() {
        return Stream.of(
                of("([w{2]})", false),
                of("(())))", false),
                of("{}[jnji)}", false)
        );
    }

    @Test
    public void shouldNotMutateArray() {
        String text = "([w{2]})";
        assertFalse(BraceAnalysis.isCorrectModification(text));
    }

//    public static Stream<Arguments> testCorrectModification() {
//        return Stream.of(
//                arguments("([w{2]})", false),
//                arguments("([])", true)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//
//    public void testCorrectModification(String text, BraceAnalysis expectedResult) {
//        boolean actualResult = BraceAnalysis.isCorrectModification(text);
//
//        assertEquals(expectedResult, actualResult);
//    }

}
