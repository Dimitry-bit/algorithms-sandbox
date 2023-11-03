/* 1.3.39 Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed
size N. It is useful for transferring data between asynchronous processes or for storing
log files. When the buffer is empty, the consumer waits until data is deposited; when the
buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and
an implementation that uses an array representation (with circular wrap-around). */

package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

public class RingBuffer<Item> {
    private Item[] items;
    private int head;
    private int tail;
    private int capacity;
    private int N;

    public RingBuffer(int capacity) {
        if (capacity < 2) {
            throw new IllegalArgumentException();
        }

        items = (Item[]) new Object[capacity];
        head = tail = 0;
        this.capacity = capacity;
        N = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int count() {
        return N;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public boolean isFull() {
        return (N == capacity);
    }

    public boolean enqueue(Item item) {
        if (isFull()) {
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % capacity;
        N++;

        return true;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("RingBuffer is empty");
        }

        Item item = items[head];
        head = (head + 1) % capacity;
        N--;

        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("RingBuffer is empty");
        }

        return items[head];
    }

    public static void main(String[] args) {
        RingBuffer<Integer> r = new RingBuffer<>(10);

        int value = 1001;
        while (r.enqueue((value++))) {
        }
        while (!r.isEmpty()) {
            System.out.printf("read %d\n", r.dequeue());
        }
    }
}