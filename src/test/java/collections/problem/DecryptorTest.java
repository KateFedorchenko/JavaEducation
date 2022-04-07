package collections.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DecryptorTest {
    @Test
    public void shouldDecipherString() throws Exception{
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put((char) ('b' + i), (char) ('a' + i));
        }
        String str = "kbwb";
        String result = Decriptor.decrypt(str,map);
        assertEquals("java",result);
    }
}

