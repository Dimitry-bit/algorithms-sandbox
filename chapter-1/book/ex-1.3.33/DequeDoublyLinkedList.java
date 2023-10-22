/* Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
a queue but supports adding and removing items at both ends. */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeDoublyLinkedList<Item> implements Iterable<Item> {
    private class DoubleNode {
        Item value;
        DoubleNode next;
        DoubleNode prev;
    }

    private DoubleNode left;
    private DoubleNode right;
    private int N;

    public DequeDoublyLinkedList() {
        left = right = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (left == null);
    }

    public void pushLeft(Item item) {
        DoubleNode node = new DoubleNode();
        node.value = item;

        if (left == null) {
            left = right = node;
        } else {
            node.next = left;
            left.prev = node;
            left = node;
        }
        N++;
    }

    public void pushRight(Item item) {
        DoubleNode node = new DoubleNode();
        node.value = item;

        if (left == null) {
            left = right = node;
        } else {
            node.prev = right;
            right.next = node;
            right = node;
        }
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        Item item = left.value;
        if (left.next != null) {
            left.next.prev = null;
        }
        left = left.next;
        N--;

        if (N == 0) {
            right = null;
        }

        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        Item item = right.value;
        if (right.prev != null) {
            right.prev.next = null;
        }
        right = right.prev;
        N--;

        if (N == 0) {
            left = null;
        }

        return item;
    }

    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Item> {
        private DoubleNode current = left;

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            Item item = current.value;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove in loops is not supported!");
        }
    }

    public static void main(String[] args) {
        DequeDoublyLinkedList<String> deque = new DequeDoublyLinkedList<>();

        deque.pushLeft("First");
        printDeque(deque);

        deque.pushLeft("Left");
        printDeque(deque);

        deque.pushRight("Second");
        printDeque(deque);

        System.out.println("\nRemove Tests:\n");

        System.out.printf("Remove Left: '%s'\n", deque.popLeft().toString());
        printDeque(deque);

        System.out.printf("Remove Right: '%s'\n", deque.popRight().toString());
        printDeque(deque);

        deque.popRight();
        printDeque(deque);
    }

    private static <T> void printDeque(DequeDoublyLinkedList<T> deque) {
        System.out.print("Out: ");
        for (T s : deque) {
            System.out.printf("%s, ", s.toString());
        }
        System.out.printf("\n(Size=%d, IsEmpty=%s)", deque.size(), (deque.isEmpty()) ? "True" : "False");
        System.out.println();
    }
}