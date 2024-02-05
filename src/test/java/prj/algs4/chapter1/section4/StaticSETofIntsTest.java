package prj.algs4.chapter1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StaticSETofIntsTest {
    @Test
    public void staticSETofInts_multiValArray_shouldReturnCount() {
        StaticSETofInts ints = new StaticSETofInts(new int[] { 1, 2, 1 });

        int expected = 2;
        int actual = ints.howMany(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void staticSETofInts_singleElementArray_shouldReturnOne() {
        StaticSETofInts ints = new StaticSETofInts(new int[] { 1 });

        int expected = 1;
        int actual = ints.howMany(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void staticSETofInts_arrayDoesNotContainKey_shouldReturnZero() {
        StaticSETofInts ints = new StaticSETofInts(new int[] { 1, 1, 1 });

        int expected = 0;
        int actual = ints.howMany(0);

        Assertions.assertEquals(expected, actual);
    }
}
