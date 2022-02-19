package collections.problem;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import utils.ListArgumentConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RemoveDuplicatesTest {
    public static Stream<Arguments> shouldRemoveDuplicates() {
        return Stream.of(
            arguments(List.of())
        );
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "[1,2,3]   | [1,2,3]",
                "[1,1,1] | [1]",
            "[1,2,2,3] | [1,2,3]",
            "[1,1,1,1] | [1]",
            "[1,1]     | [1]",
            "[1]       | [1]",
            "[]        | []"
        },
        delimiter = '|'
    )
    public void shouldRemoveDuplicates(
        @ConvertWith(ListArgumentConverter.class) List<Integer> nums,
        @ConvertWith(ListArgumentConverter.class) List<Integer> expected
    ) {
        RemoveDuplicates.removeDuplicates(nums);

        assertEquals(expected, nums);
    }
}
