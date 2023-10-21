/* Add a method peek() to Stack that returns the most recently inserted item on
the stack (without popping it). */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackResizingArray<Item> implements Iterable<Item> {

    private Item[] items;
    private int N;

    public StackResizingArray() {
        items = (Item[]) new Object[1];
        N = 0;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == items.length) {
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack size is 0");
        }

        Item item = items[--N];
        items[N] = null;
        if (!isEmpty() && N == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack size is 0");
        }

        return items[N - 1];
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        System.arraycopy(items, 0, tmp, 0, N);
        items = tmp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        public boolean hasNext() {
            return (i > 0);
        }

        public Item next() {
            return items[--i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        StackResizingArray<Integer> stack = new StackResizingArray<>();

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