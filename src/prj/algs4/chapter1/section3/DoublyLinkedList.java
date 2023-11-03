/* 1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where
each node contains a reference to the item preceding it and the item following it in the
list (null if there is no such item). Then implement static methods for the following
tasks: insert at the beginning, insert at the end, remove from the beginning, remove
from the end, insert before a given node, insert after a given node, and remove a given
node. */

package prj.algs4.chapter1.section3;


import java.util.Iterator;
import java.util.NoSuchElementException;

import prj.utils.Utils;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private class DoubleNode {
        private Item value;
        private DoubleNode next;
        private DoubleNode prev;
    }

    private DoubleNode head;
    private DoubleNode tail;
    private int N;

    public DoublyLinkedList() {
        head = tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public void insertFront(Item item) {
        DoubleNode oldHead = head;
        head = new DoubleNode();
        head.value = item;
        head.next = oldHead;

        if (isEmpty()) {
            tail = head;
        } else {
            oldHead.prev = head;
        }
        N++;
    }

    public void insertBack(Item item) {
        DoubleNode oldTail = tail;
        tail = new DoubleNode();
        tail.value = item;
        tail.prev = oldTail;

        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        N++;
    }

    public void insertBefore(Item item, int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        if (index == 0) {
            insertFront(item);
        } else {
            DoubleNode node = new DoubleNode();
            DoubleNode p = getNode(index);

            node.value = item;
            node.next = p;
            node.prev = p.prev;
            p.prev.next = node;
            p.prev = node;

            N++;
        }
    }

    public void insertAfter(Item item, int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        if (index == N - 1) {
            insertBack(item);
        } else {
            DoubleNode node = new DoubleNode();
            DoubleNode p = getNode(index);

            node.value = item;
            node.prev = p;
            node.next = p.next;
            p.next.prev = node;
            p.next = node;

            N++;
        }
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

        if (isEmpty()) {
            head = tail = null;
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

        if (isEmpty()) {
            head = tail = null;
        }

        return item;
    }

    public int remove(Item item) {
        if (isEmpty()) {
            throw new NoSuchElementException("DoublyLinkedList is empty");
        }

        int removeCount = 0;

        while (head != null && head.value.equals(item)) {
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
            removeCount++;
        }

        DoubleNode p = head;
        DoubleNode last = p;
        while (p != null) {
            if (p.value.equals(item)) {
                p.prev.next = p.next;
                if (p.next != null) {
                    p.next.prev = p.prev;
                }
                removeCount++;
            } else {
                last = p;
            }
            p = p.next;
        }
        tail = last;
        N -= removeCount;

        if (isEmpty()) {
            head = tail = null;
        }

        return removeCount;
    }

    public Item removeAt(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        if (index == 0) {
            return removeFront();
        } else if (index == N - 1) {
            return removeBack();
        }

        DoubleNode p = getNode(index);
        p.next.prev = p.prev;
        p.prev.next = p.next;
        N--;

        return p.value;
    }

    public int find(Item item) {
        int index = -1;
        int i = 0;
        for (DoubleNode p = head; p != null; p = p.next, ++i) {
            if (p.value.equals(item)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private DoubleNode getNode(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        DoubleNode p = head;
        while (index-- > 0) {
            p = p.next;
        }

        return p;
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
        Utils.printCollection(list);

        list.insertFront("Front");
        Utils.printCollection(list);

        list.insertBack("Second");
        Utils.printCollection(list);

        list.insertAfter("After(1)", 1);
        Utils.printCollection(list);

        list.insertBefore("Before(1)", 1);
        Utils.printCollection(list);

        System.out.println("\nRemove Tests:\n");

        System.out.printf("Remove Front: \"%s\"\n", list.removeFront().toString());
        Utils.printCollection(list);

        System.out.printf("Remove Back: \"%s\"\n", list.removeBack().toString());
        Utils.printCollection(list);

        System.out.println("Remove: \"First\"");
        list.remove("First");
        Utils.printCollection(list);

        list.removeFront();
        list.removeFront();
        Utils.printCollection(list);
    }
}