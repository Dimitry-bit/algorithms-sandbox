package prj.algs4.chapter2.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void insertionSort_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        ShellSortIncSeq.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    public void insertionSort_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        ShellSortIncSeq.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    public void insertionSort_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        ShellSortIncSeq.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    public void insertionSort_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        ShellSortIncSeq.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }
}
