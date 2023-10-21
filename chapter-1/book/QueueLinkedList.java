import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int N;

    private class Node {
        Item value;
        Node next;
    }
    
    public QueueLinkedList() { 
       head = tail = null; 
       N = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldNode = tail;
        tail = new Node();
        tail.value = item;
        tail.next = null;

        if (isEmpty()) {
            head = tail;
        } else {
            oldNode.next = tail;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue size is 0");
        }

        Item item = head.value;
        head = head.next;
        N--;

        if (isEmpty()) {
            tail = null;
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue size is 0");
        }

        return head.value;
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
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();

        assert (queue.isEmpty());
        assert (queue.size() == 0);

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        for (Integer n : queue) {
            System.out.println(n);
        }

        assert (queue.size() == 3);
        assert (!queue.isEmpty());
        int out = queue.dequeue();
        assert (out == 5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // throw exception
    }
}