/* 1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where
each node contains a reference to the item preceding it and the item following it in the
list (null if there is no such item). Then implement static methods for the following
tasks: insert at the beginning, insert at the end, remove from the beginning, remove
from the end, insert before a given node, insert after a given node, and remove a given
node. */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private class DoubleNode {
        Item value;
        DoubleNode next;
        DoubleNode prev;
    }

    DoubleNode head;
    DoubleNode tail;
    int N;

    public DoublyLinkedList() {
        head = tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    private DoubleNode getNodeAt(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        DoubleNode p = head;
        while (index-- > 0) {
            p = p.next;
        }

        return p;
    }

    public void insertBefore(Item item, int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        DoubleNode node = new DoubleNode();
        node.value = item;

        DoubleNode p = getNodeAt(index);
        node.next = p;
        node.prev = p.prev;
        p.prev.next = node;
        p.prev = node;

        N++;
    }

    private void insertAfter(Item item, int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        DoubleNode node = new DoubleNode();
        node.value = item;

        DoubleNode p = getNodeAt(index);
        node.prev = p;
        node.next = p.next;
        p.next.prev = node;
        p.next = node;

        N++;
    }

    public void insertFront(Item item) {
        DoubleNode node = new DoubleNode();
        node.value = item;

        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        N++;
    }

    public void insertBack(Item item) {
        DoubleNode node = new DoubleNode();
        node.value = item;

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        N++;
    }

    public Item removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("DoublyLinkedList is empty");
        }

        Item item = head.value;
        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
        N--;

        if (N == 0) {
            tail = null;
        }

        return item;
    }

    public Item removeBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("DoublyLinkedList is empty");
        }

        Item item = tail.value;
        if (tail.prev != null) {
            tail.prev.next = null;
        }
        tail = tail.prev;
        N--;

        if (N == 0) {
            head = null;
        }

        return item;
    }

    public void remove(Item item) {
        if (isEmpty()) {
            throw new NoSuchElementException("DoublyLinkedList is empty");
        }

        if (head.value.equals(item)) {
            removeFront();
            return;
        } else if (tail.value.equals(item)) {
            removeBack();
            return;
        }

        DoubleNode p = head;
        while (p != null) {
            if (p.value.equals(item)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                N--;
                return;
            }
            p = p.next;
        }
    }

    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Item> {
        private DoubleNode current = head;

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
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.insertFront("First");
        printList(list);

        list.insertFront("Front");
        printList(list);

        list.insertBack("Second");
        printList(list);

        list.insertAfter("After(1)", 1);
        printList(list);

        list.insertBefore("Before(1)", 1);
        printList(list);

        System.out.println("\nRemove Tests:\n");

        System.out.printf("Remove Front: '%s'\n", list.removeFront().toString());
        printList(list);

        System.out.printf("Remove Back: '%s'\n", list.removeBack().toString());
        printList(list);

        System.out.println("Remove 'First'");
        list.remove("First");
        printList(list);

        list.removeFront();
        list.removeFront();
        printList(list);
    }

    public static <T> void printList(DoublyLinkedList<T> list) {
        System.out.print("Out: ");
        for (T s : list) {
            System.out.printf("%s, ", s.toString());
        }
        System.out.printf("\n(Size=%d, IsEmpty=%s)", list.size(), (list.isEmpty()) ? "True" : "False");
        System.out.println();
    }
}