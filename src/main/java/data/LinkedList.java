package data;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;

    public LinkedList() {
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public void add(T value) {
        Node<T> newTail = new Node<T>(value);
        Node<T> tail = findTail();
        if (tail == null) {
            this.head = newTail;
        } else {
            tail.link(newTail);
        }
    }

    public Iterator<T> iterator() {
        return new NodeIterator<>(head);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        boolean isFirst = true;
        for (T t : this) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(", ");
            }
            builder.append(t);
        }
        builder.append("]");
        return builder.toString();
    }

    public Node<T> getHead() {
        return this.head;
    }

    private Node<T> findTail() {
        if (this.head == null) {
            return null;
        }

        Node<T> node = this.head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    public static class Node<T> {

        private final T value;

        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public void link(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

    }

    static class NodeIterator<T> implements Iterator<T> {

        private Node<T> current;
        private Node<T> next;

        public NodeIterator(Node<T> start) {
            this.current = null;
            this.next = start;
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.current = next;
            this.next = current.getNext();

            return current.getValue();
        }

    }
}
