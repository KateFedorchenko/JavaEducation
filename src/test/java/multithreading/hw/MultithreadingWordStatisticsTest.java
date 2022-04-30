package multithreading.hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MultithreadingWordStatisticsTest {
    public static Stream<Arguments> shouldGiveMultithreadingWordStatistics(){
        return Stream.of(
                arguments("dura lex sed lex", Map.ofEntries(
                        entry("dura", 1),
                        entry("lex", 2),
                        entry("sed", 1)
                )),
                arguments("ad ad", Map.ofEntries(
                        entry("ad", 2)
                )),
                arguments("dura LEX SED lex", Map.ofEntries(
                        entry("dura", 1),
                        entry("lex", 2)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource
    public void shouldGiveMultithreadingWordStatistics(String str, Map<String,Integer> expectedAnswer) throws Exception{
        Map<String,Integer> actualAnswer = MultithreadingWordStatistics.getWordStatisticsMT(str,Runtime.getRuntime().availableProcessors());

        assertEquals(expectedAnswer,actualAnswer);
    }

}