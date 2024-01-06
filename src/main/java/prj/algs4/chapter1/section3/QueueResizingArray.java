/* Develop a class ResizingArrayQueueOfStrings that implements the queue
abstraction with a fixed-size array, and then extend your implementation to use array
resizing to remove the size restriction. */

package prj.algs4.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueResizingArray<Item> implements Iterable<Item> {

    private Item[] items;
    private int N;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueResizingArray() {
        items = (Item[]) new Object[1];
        N = 0;
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == items.length) {
            resize(items.length * 2);
        }

        items[tail++] = item;
        tail %= items.length;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue size is 0");
        }

        Item item = items[head];
        items[head++] = null;
        N--;
        head %= items.length;

        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue size is 0");
        }

        return items[head];
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; ++i) {
            tmp[i] = items[(head + i) % items.length];
        }
        head = 0;
        tail = N;
        items = tmp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<Item> {

        private int i = 0;

        public boolean hasNext() {
            return (i < N);
        }

        public Item next() {
            Item item = items[(head + i) % items.length];
            i++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }

    }

    public static void main(String[] args) {
        QueueResizingArray<String> q = new QueueResizingArray<>();

        for (String arg : args) {
            if (arg.equals("-")) {
                System.out.print(q.dequeue() + ' ');
            } else {
                q.enqueue(arg);
            }
        }

        System.out.println("(" + q.size() + " left on queue)");
    }
}