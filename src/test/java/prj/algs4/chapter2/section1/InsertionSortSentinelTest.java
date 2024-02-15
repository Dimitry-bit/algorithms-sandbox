package prj.algs4.chapter2.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortSentinelTest {

    @Test
    public void insertionSortSentinel_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        InsertionSortSentinel.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void insertionSortSentinel_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        InsertionSortSentinel.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void insertionSortSentinel_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        InsertionSortSentinel.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void insertionSortSentinel_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        InsertionSortSentinel.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }
}
