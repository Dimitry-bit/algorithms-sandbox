/* 1.3.29 Write a Queue implementation that uses a circular linked list, which is the same
as a linked list except that no links are null and the value of last.next is first when-
ever the list is not empty. Keep only one Node instance variable (last). */

package prj.algs4.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueCircularLinkedList<Item> implements Iterable<Item> {
    private Node tail;
    private int N;

    public QueueCircularLinkedList() {
        tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (tail == null);
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.value = item;

        if (tail == null) {
            tail = node;
            tail.next = node;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }

        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Item item = tail.next.value;
        tail.next = tail.next.next;
        --N;

        if (N == 0) {
            tail = null;
        }

        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return tail.next.value;
    }

    private class Node {
        Item value;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = tail.next;
        private int n = N;

        public boolean hasNext() {
            return (n > 0);
        }

        public Item next() {
            Item item = current.value;
            current = current.next;
            --n;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove in loops is not supported!");
        }
    }

    public static void main(String[] args) {
        QueueCircularLinkedList<String> q = new QueueCircularLinkedList<>();

        for (String arg : args) {
            if (arg.equals("-")) {
                System.out.print(q.dequeue() + ' ');
            } else {
                q.enqueue(arg);
            }
        }

        System.out.println("(" + q.size() + " left on queue)");
        System.out.printf("(IsEmpty = %s)", (q.isEmpty()) ? "Yes" : "No");
    }
}
