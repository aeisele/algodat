import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeTest {

    @Test
    public void nodeAtBeginningTest() {
        DeleteNode.LinkedListNode head = new DeleteNode.LinkedListNode(1);
        appendToList(head, 2);
        appendToList(head, 3);
        appendToList(head, 4);

        DeleteNode.deleteNode(head);

        DeleteNode.LinkedListNode node = head;
        assertEquals(2, node.value);

        node = node.next;
        assertEquals(3, node.value);

        node = node.next;
        assertEquals(4, node.value);

        assertNull(node.next);
    }

    @Test
    public void nodeInTheMiddleTest() {
        DeleteNode.LinkedListNode head = new DeleteNode.LinkedListNode(1);
        DeleteNode.LinkedListNode nodeToDelete = appendToList(head, 2);
        appendToList(head, 3);
        appendToList(head, 4);

        DeleteNode.deleteNode(nodeToDelete);

        DeleteNode.LinkedListNode node = head;
        assertEquals(1, node.value);

        node = node.next;
        assertEquals(3, node.value);

        node = node.next;
        assertEquals(4, node.value);

        assertNull(node.next);
    }

    @Test
    public void nodeAtTheEndTest() {

        DeleteNode.LinkedListNode head = new DeleteNode.LinkedListNode(1);
        appendToList(head, 2);
        appendToList(head, 3);
        DeleteNode.LinkedListNode nodeToDelete = appendToList(head, 4);

        assertThrows(Exception.class, () -> {
            DeleteNode.deleteNode(nodeToDelete);
        });
    }

    @Test()
    public void oneNodeListTest() {
        DeleteNode.LinkedListNode head = new DeleteNode.LinkedListNode(1);
        assertThrows(Exception.class, () -> {
            DeleteNode.deleteNode(head);
        });
    }

    private static DeleteNode.LinkedListNode appendToList(final DeleteNode.LinkedListNode head, int value) {
        DeleteNode.LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new DeleteNode.LinkedListNode(value);
        return current.next;
    }

}