package prj.algs4.chapter2.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSort3MedianTest {

    @Test
    public void quickSort3Median_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        QuickSort3Median.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSort3Median_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        QuickSort3Median.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSort3Median_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        QuickSort3Median.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSort3Median_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        QuickSort3Median.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

}
