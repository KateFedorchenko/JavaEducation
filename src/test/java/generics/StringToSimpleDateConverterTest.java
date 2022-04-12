package generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToSimpleDateConverterTest {
    StringToSimpleDateConverter testTarget;

    @BeforeEach
    void setup(){
        testTarget = new StringToSimpleDateConverter();
    }

    @Test
    public void shouldConvertStringsWhenMonthInLowerCase(){
        String date = "2000-may-2";
        SimpleDate result = testTarget.convert(date);

        assertEquals(2000,result.getYear());
        assertEquals(Month.MAY,result.getMonth());
        assertEquals(2,result.getDay());
    }



}