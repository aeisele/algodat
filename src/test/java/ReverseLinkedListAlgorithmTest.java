import data.LinkedList;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListAlgorithmTest {

    @Test
    void testReverse() {

        LinkedList<String> list = new LinkedList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");

        LinkedList<String> reversed = ReverseLinkedListAlgorithm.reverse(list);
        assertThat(reversed).containsExactly("baz", "bar", "foo");
    }

    @Test
    void testReverse_emptyList() {

        LinkedList<String> list = new LinkedList<>();

        LinkedList<String> reversed = ReverseLinkedListAlgorithm.reverse(list);
        assertThat(reversed).isEmpty();
    }

    @Test
    void testReverse_singleElement() {

        LinkedList<String> list = new LinkedList<>();
        list.add("foo");

        LinkedList<String> reversed = ReverseLinkedListAlgorithm.reverse(list);
        assertThat(reversed).containsExactly("foo");
    }
}