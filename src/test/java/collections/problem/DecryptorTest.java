package collections.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DecryptorTest {
    @Test
    public void shouldDecipherString() throws Exception{
        String str = "kbwb";
        String result = Decriptor.decrypt(str);
        assertEquals("java",result);
    }
}