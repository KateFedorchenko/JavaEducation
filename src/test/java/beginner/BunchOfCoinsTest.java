package beginner;

import java.lang.reflect.Constructor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beginner.BunchOfCoins;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BunchOfCoinsTest {
    private static final Pattern pattern = Pattern.compile("\\[(\\d+),(\\d+),(\\d+),(\\d+)]");

    @ParameterizedTest
    @CsvSource(value = {
        "[1,2,3,4] \t [3,3,3,3] \t [4,5,6,7]",
        "[0,0,0,0] \t [0,0,0,0] \t [0,0,0,0]",
        "[1,0,1,0] \t [0,1,0,1] \t [1,1,1,1]"
    },
        delimiter = '\t'
    )
    public void testCombine(
        @ConvertWith(BunchOfCoinsFromString.class) BunchOfCoins lhs,
        @ConvertWith(BunchOfCoinsFromString.class) BunchOfCoins rhs,
        @ConvertWith(BunchOfCoinsFromString.class) BunchOfCoins expected
    ) {
        lhs.combineWithOther(rhs);

        assertBunchEquals(lhs, expected);
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "[1,1,1,1]         \t 12 \t [0,1,0,1] \t [1,0,1,0]",
            "[100,0,0,0]       \t 2  \t null      \t [100,0,0,0]",
            "[0,2,0,10]        \t 31 \t null      \t [0,2,0,10]",
            "[100,100,100,100] \t 99 \t [0,2,1,9] \t [100,98,99,91]"
        },
        delimiter = '\t'
    )
    public void testWithdrawal(
        @ConvertWith(BunchOfCoinsFromString.class) BunchOfCoins bunch,
        int amount,
        @ConvertWith(BunchOfCoinsFromString.class) BunchOfCoins expectedWithdrawal,
        @ConvertWith(BunchOfCoinsFromString.class) BunchOfCoins expectedRemain
    ) {
        BunchOfCoins withdrawal = bunch.greedyWithdrawal(amount);

        assertBunchEquals(expectedWithdrawal, withdrawal);
        assertBunchEquals(expectedRemain, bunch);
    }

    public void assertBunchEquals(BunchOfCoins expected, BunchOfCoins actual) {
        if (expected == null && actual == null) return;

        if (expected == null ^ actual == null)
            fail(() -> "Expected: \n" + expected + ", but actual: \n" + actual);

        boolean eq;

        eq = expected.getOnes() == actual.getOnes();
        eq &= expected.getTwos() == actual.getTwos();
        eq &= expected.getFives() == actual.getFives();
        eq &= expected.getTens() == actual.getTens();

        if (!eq)
            fail(() -> "Expected: \n" + expected + ", but actual: \n" + actual);
    }

    public static class BunchOfCoinsFromString implements ArgumentConverter {
        @Override public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
            String arg = source.toString().trim();

            if ("null".equals(arg)) return null;

            Matcher m = pattern.matcher(arg);

            assert m.matches();

            BunchOfCoins res;

            try {
                Constructor<BunchOfCoins> ctor = BunchOfCoins.class.getConstructor(int.class, int.class, int.class, int.class);

                res = ctor.newInstance(
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3)),
                    Integer.parseInt(m.group(4))
                );

            } catch (Exception e) {
                throw new ArgumentConversionException("Тест ожидает что у класса bunch of coins будет конструктор beginner.BunchOfCoins(int,int,int,int)", e);
            }

            return res;
        }
    }
}