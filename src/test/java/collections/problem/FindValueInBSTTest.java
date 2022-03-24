package collections.problem;

import collections.problem.FindValueInBST.Node;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindValueInBSTTest {

    public static Stream<Arguments> shouldGiveCorrectAnswer() {
        /*          foo
                  /      \
                bar      fox
               /   \     /  \
             abc   baz  for  qwe  */
        Node<String> wordTree = new Node<>("foo",
                           new Node<>("bar", new Node<>("abc"), new Node<>("baz")),
                           new Node<>("fox", new Node<>("for"), new Node<>("qwe")));

        Node<Integer> numTree = new Node<>(10, new Node<>(5), new Node<>(15));
        return Stream.of(

            arguments(new Node<>(42), 42, true ),
            arguments(new Node<>(42), 43, false ),
            arguments(numTree, 5, true),
            arguments(numTree, 12, false),
            arguments(wordTree, "foo", true),
            arguments(wordTree, "fox", true),
            arguments(wordTree, "qwe", true),
            arguments(wordTree, "xyz", false),
            arguments(wordTree, "fort", false)
        );
    }

    @ParameterizedTest
    @MethodSource
    public <T extends Comparable<T>> void shouldGiveCorrectAnswer(Node<T> root, T valToSearch, boolean expectedAnswer) {
        Assertions.assertEquals(expectedAnswer, root.containValue(valToSearch));
    }
}