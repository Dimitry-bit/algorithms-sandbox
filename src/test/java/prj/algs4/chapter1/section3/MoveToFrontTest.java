package prj.algs4.chapter1.section3;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveToFrontTest {
    @Test
    public void moveToFront_encoding_shouldReturnArrayOfInts() {
        String src = "bananaaa";
        int[] expected = { 1, 1, 13, 1, 1, 1, 0, 0 };

        int[] actual = MoveToFront.encode(src);
        boolean isEqual = Arrays.equals(expected, actual);

        Assertions.assertTrue(isEqual);
    }

    @Test
    public void moveToFront_decoding_shouldReturnDecodedString() {
        int[] src = { 1, 1, 13, 1, 1, 1, 0, 0 };
        String expected = "bananaaa";

        String actual = MoveToFront.decode(src);

        Assertions.assertEquals(expected, actual);
    }
}
