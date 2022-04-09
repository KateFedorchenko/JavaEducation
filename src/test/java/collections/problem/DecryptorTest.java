package collections.problem;

import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DecryptorTest {
    @Test
    public void shouldDecipherString(){
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 25; i++) {
            if (i == 24) {
                map.put('a', 'z');
            }
            map.put((char) ('b' + i), (char) ('a' + i));
        }
        map.put(' ', ' ');
        map.put('.', '.');
        map.put(',', ',');

        Decriptor decriptor = new Decriptor(map);
        String str = "kbwb";
        String result = decriptor.decrypt(str);
        assertEquals("java",result);
    }
}

