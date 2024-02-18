package prj.algs4.chapter2.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortCutoffTest {

    @Test
    public void quickSortCutoff_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        QuickSortCutoff.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSortCutoff_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        QuickSortCutoff.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSortCutoff_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        QuickSortCutoff.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSortCutoff_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        QuickSortCutoff.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }
}
