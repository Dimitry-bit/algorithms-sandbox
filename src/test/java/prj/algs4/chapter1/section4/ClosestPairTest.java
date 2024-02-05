package prj.algs4.chapter1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import prj.utils.Pair;

public class ClosestPairTest {
    @Test
    public void closestPair_positive_shouldReturnClosest() {
        double[] src = { 0.0, 2.0, 4.0, 5.0 };

        Pair<Double, Double> expected = new Pair<>(4.0, 5.0);
        Pair<Double, Double> actual = ClosestPair.closest(src);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void closestPair_negative_shouldReturnClosest() {
        double[] src = { -10.0, -15.0, -21.0, -30.0 };

        Pair<Double, Double> expected = new Pair<>(-10.0, -15.0);
        Pair<Double, Double> actual = ClosestPair.closest(src);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void closestPair_mixed_shouldReturnClosest() {
        double[] src = { -10.0, -3.0, 0.0, 2.0, 4.0, 20.0 };

        Pair<Double, Double> expected = new Pair<>(0.0, 2.0);
        Pair<Double, Double> actual = ClosestPair.closest(src);

        Assertions.assertEquals(expected, actual);
    }
}
