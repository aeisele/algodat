import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KThToLastNodeTest {

    @Test
    public void firstToLastNodeTest() {
        final KThToLastNode.LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 1;
        final KThToLastNode.LinkedListNode actual = KThToLastNode.kthToLastNode(k, listNodes[0]);
        final KThToLastNode.LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void secondToLastNodeTest() {
        final KThToLastNode.LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 2;
        final KThToLastNode.LinkedListNode actual = KThToLastNode.kthToLastNode(k, listNodes[0]);
        final KThToLastNode.LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void firstNodeTest() {
        final KThToLastNode.LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 4;
        final KThToLastNode.LinkedListNode actual = KThToLastNode.kthToLastNode(k, listNodes[0]);
        final KThToLastNode.LinkedListNode expected = listNodes[listNodes.length - k];
        assertSame(expected, actual);
    }

    @Test
    public void kIsGreaterThanLinkedListLengthTest() {
        final KThToLastNode.LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 5;
        assertThrows(Exception.class, () -> KThToLastNode.kthToLastNode(k, listNodes[0]));
    }

    @Test
    public void kIsZeroTest() {
        final KThToLastNode.LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final int k = 0;
        assertThrows(Exception.class, () -> KThToLastNode.kthToLastNode(k, listNodes[0]));
    }

    private static KThToLastNode.LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final KThToLastNode.LinkedListNode[] nodes = new KThToLastNode.LinkedListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new KThToLastNode.LinkedListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

}