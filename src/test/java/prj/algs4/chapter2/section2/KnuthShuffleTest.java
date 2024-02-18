package prj.algs4.chapter2.section2;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnuthShuffleTest {

    @Test
    void knuthShuffle_shuffle() {
        Integer[] a = { -3, -2, -1, 0, 1, 2, 3 };
        Integer[] sorted = a.clone();

        KnuthSuffle.shuffle(a);
        Assertions.assertFalse(Arrays.equals(a, sorted));
    }
}
