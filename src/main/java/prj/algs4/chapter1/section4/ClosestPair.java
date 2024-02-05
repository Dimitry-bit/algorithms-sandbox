/*
 * 1.4.16 Closest pair (in one dimension). Write a program that, given an array
 * a[] of N double values, finds a closest pair : two values whose difference is
 * no greater than the the difference of any other pair (in absolute value). The
 * running time of your program should be linearithmic in the worst case.
 */

package prj.algs4.chapter1.section4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import prj.utils.Pair;

public class ClosestPair {
    private ClosestPair() {
    }

    public static Pair<Double, Double> closest(double[] a) {
        if (a.length < 2) {
            throw new IllegalArgumentException("Array length should be greather than 2");
        }

        double minDiff = Math.abs(a[0] - a[1]);
        Pair<Double, Double> pair = new Pair<>(a[0], a[1]);

        for (int i = 2; i < a.length - 1; i++) {
            double diff = Math.abs(a[i] - a[i + 1]);
            if (diff < minDiff) {
                minDiff = diff;
                pair = new Pair<>(a[i], a[i + 1]);
            }
        }

        return pair;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        double[] a = in.readAllDoubles();

        Arrays.sort(a);

        Stopwatch timer = new Stopwatch();
        Pair<Double, Double> closestPair = closest(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(closestPair.getKey() + " " + closestPair.getValue());
    }
}
