package prj.algs4.chapter2.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortSentinelsTest {

    @Test
    public void quickSortSentinels_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        QuickSortSentinels.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSortSentinels_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        QuickSortSentinels.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSortSentinels_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        QuickSortSentinels.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void quickSortSentinels_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        QuickSortSentinels.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

}
