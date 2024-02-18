package prj.algs4.chapter2.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSort3WayTest {

    @Test
    public void quickSort3Way_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        QuickSort3Way.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSort3Way_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        QuickSort3Way.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSort3Way_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        QuickSort3Way.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSort3Way_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        QuickSort3Way.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

}
