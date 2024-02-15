package prj.algs4.chapter2.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnuthSuffleTest {

    @Test
    void knuthShuffle_shuffle() {
        Integer[] a = { -3, -2, -1, 0, 1, 2, 3 };
        Integer[] sorted = a.clone();

        KnuthSuffle.shuffle(a);
        int i = 0;
        for (; i < sorted.length; i++) {
            if (sorted[i] != a[i]) {
                return;
            }
        }

        Assertions.assertTrue(i < a.length);
    }
}
