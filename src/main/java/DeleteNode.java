// https://www.interviewcake.com/question/java/delete-node
public class DeleteNode {

    public static void deleteNode(LinkedListNode node) {
        if (node.next == null) {
            throw new RuntimeException("unable to delete tail");
        }

        LinkedListNode next = node.next;
        node.next = next.next;
        node.value = next.value;
    }

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

}

