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

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item> {
    public class Node {
        Item value;
        Node next;
    }

    private Node head;
    private Node tail;
    private int N;

    public LinkedList() {
        head = null;
        tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void add(Item item) {
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

    public Item remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }

        Item item = head.value;
        head = head.next;
        N--;
        return item;
    }

    public Item removeAt(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + N);
        }

        N--;
        Item item = head.value;
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            while (--index > 0) {
                current = current.next;
            }
            item = removeAfter(current);
        }

        return item;
    }

    private Item removeAfter(Node node) {
        if (node == null) {
            return null;
        }

        Item item = null;
        if (node.next != null) {
            item = node.next.value;
            node.next = (node.next.next != null) ? node.next.next : null;
        }

        return item;
    }

    private int remove(Item item) {
        int count = 0;

        while (head != null && head.value.equals(item)) {
            head = head.next;
            count++;
        }

        Node p = head;
        while (p.next != null) {
            if (p.next.value.equals(item)) {
                p.next = p.next.next;
                count++;
            } else {
                p = p.next;
            }
        }

        return count;
    }

    private void InsertAfter(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }

        b.next = a.next;
        a.next = b;
    }

    public boolean find(Item key) {
        for (Node p = head; p != null; p = p.next) {
            if (p.value.equals(key)) {
                return true;
            }
        }

        return false;
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

    public void TestInsert(Item item) {
        Node testNode = new Node();
        testNode.value = item;
        this.InsertAfter(head, testNode);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(40);
        list.add(40);
        list.add(40);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(400);
        list.add(40);
        list.add(40);

        list.TestInsert(100);

        System.out.printf("Max: %d\n", list.max());
        System.out.printf("Max Recursive: %d\n", list.maxRecursive());

        System.out.print("out: ");
        for (int n : list) {
            System.out.printf("%d ", n);
        }
        System.out.println();

        System.out.println("\nRemove index 3");
        list.removeAt(3);
        System.out.print("out: ");
        for (int n : list) {
            System.out.printf("%d ", n);
        }
        System.out.println();

        System.out.println("\nRemove index 1");
        list.removeAt(1);
        System.out.print("out: ");
        for (int n : list) {
            System.out.printf("%d ", n);
        }
        System.out.println();

        System.out.println("\nRemove index 0");
        list.removeAt(0);
        System.out.print("out: ");
        for (int n : list) {
            System.out.printf("%d ", n);
        }
        System.out.println();

        System.out.println("\nRemove all value 40");
        int count = list.remove(40);
        System.out.print("out: ");
        for (int n : list) {
            System.out.printf("%d ", n);
        }
        System.out.println();
        System.out.printf("Removed: %d\n", count);
    }
}