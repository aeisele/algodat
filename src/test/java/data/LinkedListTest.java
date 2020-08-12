package data;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

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