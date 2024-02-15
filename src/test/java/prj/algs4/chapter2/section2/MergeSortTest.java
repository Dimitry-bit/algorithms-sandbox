package prj.algs4.chapter2.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void mergeSort_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        MergeSort.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void mergeSort_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        MergeSort.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void mergeSort_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        MergeSort.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void mergeSort_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        MergeSort.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

}
