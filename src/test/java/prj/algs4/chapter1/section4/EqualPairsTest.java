package prj.algs4.chapter1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualPairsTest {
    @Test
    public void equalPairs_countDuplicateInput_shouldReturnEqualPairsCount() {
        int[] src = { 1, 1, 1, 1, 1 };
        int expected = 10;

        int actual = EqualPairs.count(src);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalPairs_countUniqueInput_shouldReturnEqualPairsCount() {
        int[] src = { 1, 2, 3 };
        int expected = 0;

        int actual = EqualPairs.count(src);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalPairs_countRandomInput_shouldReturnEqualPairsCount() {
        int[] src = { 0, 0, 6, 1, 1, 4, 2, 1, 2, 2 };
        int expected = 7;

        int actual = EqualPairs.count(src);

        Assertions.assertEquals(expected, actual);
    }
}
