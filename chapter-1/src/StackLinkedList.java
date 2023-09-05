import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinkedList<Item> implements Iterable<Item> {
    private Node head;
    private int N;

    private class Node {
        Item value;
        Node next;
    }

    public StackLinkedList() {
        head = null;
        N = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node node = new Node();
        node.next = head;
        node.value = item;
        head = node;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack size is 0");
        }

        Item item = head.value;
        head = head.next;
        N--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack size is 0");
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
        StackLinkedList<Integer> stack = new StackLinkedList<>();

        assert (stack.isEmpty());
        assert (stack.size() == 0);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (Integer n : stack) {
            System.out.println(n);
        }

        assert (stack.size() == 3);
        assert (!stack.isEmpty());
        int pop = stack.pop();
        assert (pop == 5);
        stack.pop();
        stack.pop();

        stack.pop(); // throw exception
    }
}