package prj.algs4.chapter1.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import prj.utils.Pair;

public class FarthestPairTest {
    @Test
    public void farthestPair_positive_shouldReturnFarthest() {
        double[] src = { 0.0, 2.0, 4.0, 5.0 };

        Pair<Double, Double> expected = new Pair<>(0.0, 5.0);
        Pair<Double, Double> actual = FarthestPair.farthest(src);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void farthestPair_negative_shouldReturnFarthest() {
        double[] src = { -10.0, -15.0, -21.0, -30.0 };

        Pair<Double, Double> expected = new Pair<>(-30.0, -10.0);
        Pair<Double, Double> actual = FarthestPair.farthest(src);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void farthestPair_mixed_shouldReturnFarthest() {
        double[] src = { -10.0, -3.0, 0.0, 2.0, 4.0, 20.0 };

        Pair<Double, Double> expected = new Pair<>(-10.0, 20.0);
        Pair<Double, Double> actual = FarthestPair.farthest(src);

        Assertions.assertEquals(expected, actual);
    }
}
