
// https://www.interviewcake.com/question/java/kth-to-last-node-in-singly-linked-list
public class KThToLastNode {

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (head == null) {
            throw new RuntimeException("head must not be null");
        }

        if (k < 1) {
            throw new RuntimeException("invalid k");
        }

        LinkedListNode[] window = new LinkedListNode[k];
        int windowIdx = -1;
        int length = 0;

        for (LinkedListNode node = head; node != null; node = node.next) {
            windowIdx = (windowIdx + 1) % k;
            window[windowIdx] = node;
            length++;
        }

        if (k > length) {
            throw new RuntimeException("k out of bounds");
        }

        return window[(windowIdx + 1) % k];
    }

    // given
    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

}
