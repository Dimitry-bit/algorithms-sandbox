package prj.algs4.chapter2.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnuthShuffleTest {

    @Test
    void knuthShuffle_shuffle() {
        Integer[] a = { -3, -2, -1, 0, 1, 2, 3 };
        Integer[] sorted = a.clone();

        for (int t = 0; t < 500; t++) {

            KnuthSuffle.shuffle(a);
            int i = 0;
            for (; i < sorted.length; i++) {
                if (!sorted[i].equals(a[i])) {
                    return;
                }
            }

            Assertions.assertTrue(i < a.length);
        }

        Assertions.assertTrue(true);
    }
}
