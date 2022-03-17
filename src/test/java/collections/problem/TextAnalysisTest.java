package collections.problem;

import collections.problem.TextAnalysis.AnalysisResult;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TextAnalysisTest {

    public static Stream<Arguments> textsAndResults() {
        return Stream.of(
            arguments("mama myla ramu", new AnalysisResult(3,3,3)),
            arguments("mama mama myla ramu", new AnalysisResult(4,3,3)),
            arguments("mama Mama myla ramu", new AnalysisResult(4,4,3)),
            arguments("mama Mama myla ramu", new AnalysisResult(4,4,3)),
            arguments("mama  myla ramu", new AnalysisResult(3,3,3)),
            arguments(" mama myla ramu  ", new AnalysisResult(3,3,3)),
            arguments("mama    myla    ramu", new AnalysisResult(3,3,3)),
            arguments("foo Foo fOO FOO", new AnalysisResult(4,4,1))
        );
    }

    @ParameterizedTest
    @MethodSource("textsAndResults")
    public void shouldGetCorrectResults(String text, AnalysisResult expectedResult) {
        AnalysisResult actualResult = TextAnalysis.analyzeText(text);

        assertEquals(expectedResult, actualResult);
    }
}