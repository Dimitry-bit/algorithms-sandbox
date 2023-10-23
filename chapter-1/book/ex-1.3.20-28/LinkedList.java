/* 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element 
in a linked list, if it exists. */

/* 1.3.21 Write a method find() that takes a linked list and a string key as arguments
and returns true if some node in the list has key as its item field, false otherwise. */

/* 1.3.26 Write a method remove() that takes a linked list and a string key as arguments
and removes all of the nodes in the list that have key as its item field. */

/* 1.3.27 Write a method max() that takes a reference to the first node in a linked list as
argument and returns the value of the maximum key in the list. Assume that all keys are
positive integers, and return 0 if the list is empty. */

/* 1.3.28 Develop a recursive solution to the previous question. */

import java.util.Iterator;
import java.util.NoSuchElementException;

import prj.utils.Utils;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item> {
    private class Node {
        private Item value;
        private Node next;
    }

    private Node head;
    private Node tail;
    private int N;

    public LinkedList() {
        head = tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public void add(Item item) {
        insertBack(item);
    }

    public void insertFront(Item item) {
        Node oldHead = head;
        head = new Node();
        head.value = item;
        head.next = oldHead;

        if (isEmpty()) {
            tail = head;
        }
        N++;
    }

    public void insertBack(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.value = item;
        tail.next = null;

        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        N++;
    }

    public void insertAt(Item item, int index) {
        if (index < 0 || index > N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        if (index == 0) {
            insertFront(item);
        } else if (index == N) {
            insertBack(item);
        } else {
            Node p = getNode(index - 1);
            Node node = new Node();
            node.value = item;
            node.next = p.next;
            p.next = node;
            N++;
        }
    }

    public Item removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }

        Item item = head.value;
        head = head.next;
        N--;

        if (isEmpty()) {
            head = tail = null;
        }

        return item;
    }

    public Item removeBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }

        Item item = tail.value;
        Node newLast = getNode(N - 1);
        newLast.next = null;
        tail = newLast;
        N--;

        if (isEmpty()) {
            head = tail = null;
        }

        return item;
    }

    public Item removeAt(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        Item item = null;
        if (index == 0) {
            item = removeFront();
        } else if (index == N - 1) {
            item = removeBack();
        } else {
            Node p = getNode(index - 1);
            item = p.next.value;
            p.next = p.next.next;
            N--;
        }

        return item;
    }

    public int remove(Item item) {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }

        int removeCount = 0;

        while (head != null && head.value.equals(item)) {
            head = head.next;
            removeCount++;
        }

        Node p = head;
        if (p != null) {
            while (p.next != null) {
                if (p.next.value.equals(item)) {
                    p.next = p.next.next;
                    removeCount++;
                } else {
                    p = p.next;
                }
            }
        }
        tail = p;
        N -= removeCount;

        if (isEmpty()) {
            head = tail = null;
        }

        return removeCount;
    }

    public int find(Item key) {
        int index = -1;
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (p.value.equals(key)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public Item max() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }

        Item maxItem = head.value;
        for (Node p = head; p != null; p = p.next) {
            if (p.value.compareTo(maxItem) > 0) {
                maxItem = p.value;
            }
        }

        return maxItem;
    }

    public Item maxRecursive() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }

        return _maxRecursive(head);
    }

    private Item _maxRecursive(Node p) {
        if (p.next == null) {
            return p.value;
        }

        Item value = _maxRecursive(p.next);
        return ((value.compareTo(p.value) > 0) ? value : p.value);
    }

    private Node getNode(int index) {
        Node p = head;
        while (index-- > 0) {
            p = p.next;
        }

        return p;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = head;

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
        LinkedList<Integer> list = new LinkedList<>();

        list.insertFront(600);
        list.insertBack(40);
        list.insertBack(40);
        list.insertBack(40);
        list.insertBack(10);
        list.insertBack(20);
        list.insertBack(30);
        list.insertBack(40);
        list.insertBack(400);
        list.insertBack(40);
        list.insertBack(40);

        Utils.printCollection(list);
        System.out.printf("Max: %d\n", list.max());
        System.out.printf("Max Recursive: %d\n", list.maxRecursive());

        System.out.println("\nRemove(i=3):");
        list.removeAt(3);
        Utils.printCollection(list);
        System.out.printf("Size: %d\nIsEmpty: %s\n", list.size(), list.isEmpty() ? "True" : "False");

        System.out.println("\nRemove(i=1):");
        list.removeAt(1);
        Utils.printCollection(list);
        System.out.printf("Size: %d\nIsEmpty: %s\n", list.size(), list.isEmpty() ? "True" : "False");

        System.out.println("\nRemove(i=0):");
        list.removeAt(0);
        Utils.printCollection(list);
        System.out.printf("Size: %d\nIsEmpty: %s\n", list.size(), list.isEmpty() ? "True" : "False");

        System.out.println("\nRemove(v=\"40\"):");
        int count = list.remove(40);
        Utils.printCollection(list);
        System.out.printf("Removed: %d\n", count);
        System.out.printf("Size: %d\nIsEmpty: %s\n", list.size(), list.isEmpty() ? "True" : "False");
    }
}