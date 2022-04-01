package collections.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BraceAnalysisTest {
    @Test
    public void shouldGiveIncorrectVerdict(){          //for single check
        String str = "()[";
        boolean result = BraceAnalysis.isCorrectModification(str);
        assertFalse(result);
    }


    @ParameterizedTest
    @ValueSource(strings = {"()(", "[](kk)[","{}f[","([w{2]})","([)]"})                      // for several tests
    public void shouldGiveIncorrectVerdictParameterized(String str){
        boolean result = BraceAnalysis.isCorrectModification(str);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "[](kk)","{}f"})                      // for several tests -- just for one param
    public void shouldGiveCorrectVerdictParameterized(String str){
        boolean result = BraceAnalysis.isCorrectModification(str);
        assertTrue(result);
    }





}