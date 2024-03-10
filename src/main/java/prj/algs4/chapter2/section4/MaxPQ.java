/* 2.4.19 Implement the constructor for MaxPQ that takes an array of items as argument,
using the bottom-up heap construction method described on page 323 in the text. */

/* 2.4.22 Array resizing. Add array resizing to MaxPQ, and prove bounds like those of
Proposition Q for array accesses, in an amortized sense. */

/* 2.4.27 Find the minimum. Add a min() method to MaxPQ. Your implementation
should use constant time and constant extra space. */

package prj.algs4.chapter2.section4;

import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;
    private Key min;

    @SuppressWarnings("unchecked")
    public MaxPQ() {
        pq = (Key[]) new Comparable[1];
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(Key[] a) {
        N = a.length;

        pq = (Key[]) new Comparable[N + 1];
        System.arraycopy(a, 0, pq, 1, N);

        for (int k = N / 2; k >= 1; k--)
            sink(k, N);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pirority queue is empty");
        }

        return pq[1];
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pirority queue is empty");
        }

        return min;
    }

    public void insert(Key v) {
        if (N + 1 >= pq.length) {
            resize((pq.length * 2) + 1);
        }

        if (min == null || (v.compareTo(min) < 0)) {
            min = v;
        }

        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pirority queue is empty");
        }

        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);

        if ((N > 0) && (N == pq.length / 4)) {
            resize(pq.length / 2);
        }

        if (min == max) {
            min = null;
        }

        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;

            if ((j < N) && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    private void sink(int k, int max) {
        while (k * 2 <= max) {
            int j = k * 2;

            if ((j < max) && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return (pq[i].compareTo(pq[j]) < 0);
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Key[] tmp = (Key[]) new Comparable[max];
        System.arraycopy(pq, 0, tmp, 0, N);
        pq = tmp;
    }
}
