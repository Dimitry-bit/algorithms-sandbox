
package prj.algs4.chapter2.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortBottomUpTest {

    @Test
    public void mergeSortBottomUp_randomArray_sort() {
        Integer[] src = { 10, -2, 8, 29, 0, -1 };

        Integer[] expected = { -2, -1, 0, 8, 10, 29 };
        MergeSortBottomUp.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void mergeSortBottomUp_sortOneElement_sort() {
        Integer[] src = { 1 };

        Integer[] expected = { 1 };
        MergeSortBottomUp.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void mergeSortBottomUp_duplicateKeys_sort() {
        Integer[] src = { 1, 1, 1 };

        Integer[] expected = { 1, 1, 1 };
        MergeSortBottomUp.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

    @Test
    public void mergeSortBottomUp_emptyArray_sort() {
        Integer[] src = {};

        Integer[] expected = {};
        MergeSortBottomUp.sort(src);

        Assertions.assertArrayEquals(expected, src);
    }

}
