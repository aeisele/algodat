package data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void testFillAndIterate() {
        LinkedList<String> list = new LinkedList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");

        assertThat(list).containsExactly("foo", "bar", "baz");
    }


}