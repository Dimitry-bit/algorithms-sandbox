/* Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
a queue but supports adding and removing items at both ends. */

package prj.algs4.chapter1.section3;

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
}