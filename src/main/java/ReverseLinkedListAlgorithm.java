import data.LinkedList;

// https://www.interviewcake.com/question/python/reverse-linked-list
public class ReverseLinkedListAlgorithm {

    // in place
    public static<T> LinkedList<T> reverse(LinkedList<T> list) {

        LinkedList.Node<T> node = list.getHead();

        if (node == null) {
            return list;
        }

        LinkedList.Node<T> next = node.getNext();

        if (next == null) {
            return list;
        }

        // A -> B -> C -> D -> null
        // A -> null
        // B -> A -> null
        // C -> B -> A -> null
        // D -> C -> B -> A -> null
        LinkedList.Node<T> previous = null;
        while (node != null) {
            next = node.getNext();
            node.link(previous);
            previous = node;
            node = next;
        }

        return new LinkedList<>(previous);
    }

}

