//package multithreading.hw;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Map;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.params.provider.Arguments.arguments;
//
//class MultithreadingWordStatisticsTest {
//    public static Stream<Arguments> shouldGiveMultithreadingWordStatistics(){
//        return Stream.of(
//                arguments("dura lex sed lex ad infinum per aspera ad astra", ??),
//                arguments("dura lex sed lex ad infinum per aspera ad astra", ??)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    public void shouldGiveMultithreadingWordStatistics(String str, Map<String,Integer> expectedAnswer){
//        int actualAnswer = MultithreadingWordStatistics.getWordStatisticsMT(String str);
//
//        assertEquals(expectedAnswer,actualAnswer);
//    }
//
//}