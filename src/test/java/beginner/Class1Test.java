package beginner;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import beginner.Class1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Class1Test {

    public static Stream<Arguments> testMinMaxValueHolder() {
        return Stream.of(
            arguments(List.of(1), List.of(1), List.of(1)),
            arguments(List.of(1,2), List.of(1,1), List.of(1,2)),
            arguments(List.of(3,2,1), List.of(3,2,1), List.of(3,3,3)),
            arguments(List.of(0), List.of(0), List.of(0)),
            arguments(List.of(1,3,2), List.of(1,1,1), List.of(1,3,3))
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testMinMaxValueHolder(List<Integer> values, List<Integer> minVals, List<Integer> maxVals) {
        Class1.MinMaxValueHolder holder = new Class1.MinMaxValueHolder();

        Iterator<Integer> minIt = minVals.iterator();
        Iterator<Integer> maxIt = maxVals.iterator();

        for (Integer val : values) {
            holder.push(val);

            assertEquals(minIt.next(), holder.min());
            assertEquals(maxIt.next(), holder.max());
        }
    }

    @Test
    public void testMinMaxValueHolderDefaults() {
        Class1.MinMaxValueHolder holder = new Class1.MinMaxValueHolder();

        assertEquals(0, holder.min());
        assertEquals(0, holder.max());
    }

}