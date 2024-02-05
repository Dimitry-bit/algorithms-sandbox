package prj.algs4.chapter1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void binarySearch_smallestIndex_shouldReturnSmallest() {
        int[] src = { 1, 1, 1, 1, 1 };

        int expected = 0;
        int actual = BinarySearch.BinarySearchSmallestIndex(src, 1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void binarySearch_smallestIndex_shouldReturnNegativeOne() {
        int[] src = { 1, 2, 3, 4, 5 };

        int expected = -1;
        int actual = BinarySearch.BinarySearchSmallestIndex(src, 0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void binarySearch_largestIndex_shouldReturnLargest() {
        int[] src = { 1, 1, 1, 1, 1 };

        int expected = 4;
        int actual = BinarySearch.BinarySearchLargestIndex(src, 1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void binarySearch_largestIndex_shouldReturnNegativeOne() {
        int[] src = { 1, 2, 3, 4, 5 };

        int expected = -1;
        int actual = BinarySearch.BinarySearchLargestIndex(src, 0);

        Assertions.assertEquals(expected, actual);
    }
}
