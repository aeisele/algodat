import data.LinkedListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListCycleTest {

    @Test
    void testContainsCycle_headOnly() {
        LinkedListNode head = new LinkedListNode(1);
        final boolean containsCycle = LinkedListCycle.containsCycle(head);
        assertThat(containsCycle).isFalse();
    }

    @Test
    void testContainsCycle_no() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode tail = new LinkedListNode(2);
        head.next = tail;

        final boolean containsCycle = LinkedListCycle.containsCycle(head);
        assertThat(containsCycle).isFalse();
    }

    @Test
    void testContainsCycle_yes() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode middle = new LinkedListNode(2);
        LinkedListNode tail = new LinkedListNode(3);
        head.next = middle;
        middle.next = tail;
        tail.next = middle;

        final boolean containsCycle = LinkedListCycle.containsCycle(head);
        assertThat(containsCycle).isTrue();
    }

}
