import data.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    // better algo: slow and fast "runner" +1 vs +2 -> if they overlap there was a cycle
    public static boolean containsCycle(LinkedListNode head) {
        Set<LinkedListNode> visited = new HashSet<>();

        visited.add(head);
        LinkedListNode node = head.next;
        while (node != null) {
            if (visited.contains(node)) {
                return true;
            }
            visited.add(node);
            node = node.next;
        }

        return false;
    }

}
