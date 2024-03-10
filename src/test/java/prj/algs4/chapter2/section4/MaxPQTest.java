package prj.algs4.chapter2.section4;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxPQTest {

    @Test
    public void maxPQ_create_sizeShouldBeZero() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        Assertions.assertEquals(0, pq.size());
        Assertions.assertTrue(pq.isEmpty());
    }

    @Test
    public void maxPQ_createFromArray() {
        Integer[] src = { 1, 2, 3, 4, 5 };
        MaxPQ<Integer> pq = new MaxPQ<>(src);

        for (int i = src.length - 1; i <= 0; i--) {
            Assertions.assertEquals(src[i], pq.delMax());
        }

        Assertions.assertEquals(src.length, pq.size());
        Assertions.assertTrue(!pq.isEmpty());
    }

    @Test
    public void maxPQ_insert() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        pq.insert(0);

        Assertions.assertEquals(1, pq.size());
        Assertions.assertFalse(pq.isEmpty());
    }

    @Test
    public void maxPQ_min_shouldReturnMinimum() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        pq.insert(0);
        pq.insert(1);

        Assertions.assertEquals(0, pq.min());
        Assertions.assertEquals(2, pq.size());
    }

    @Test
    public void maxPQ_max_shouldReturnMaximum() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        pq.insert(0);
        pq.insert(1);

        Assertions.assertEquals(1, pq.max());
        Assertions.assertEquals(2, pq.size());
    }

    @Test
    public void maxPQ_delMax_shouldDeleteAndReturnMaximum() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        pq.insert(0);
        pq.insert(1);

        Assertions.assertEquals(1, pq.delMax());
        Assertions.assertEquals(1, pq.size());
    }

    public void maxPQ_maxEmpty_shouldThrowException() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, pq::max);
    }

    public void maxPQ_delMaxEmpty_shouldThrowException() {
        MaxPQ<Integer> pq = new MaxPQ<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, pq::delMax);
    }
}
