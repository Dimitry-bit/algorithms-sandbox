/* 1.4.17 Farthest pair (in one dimension). Write a program that, given an array a[] of N
double values, finds a farthest pair : two values whose difference is no smaller than the
the difference of any other pair (in absolute value). The running time of your program
should be linear in the worst case.*/

package prj.algs4.chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import prj.utils.Pair;

public class FarthestPair {
    private FarthestPair() {
    }

    public static Pair<Double, Double> farthest(double[] a) {
        if (a.length < 2) {
            throw new IllegalArgumentException("Array length should be greather than 2");
        }

        double currentMin = Math.min(a[0], a[1]);
        double currentMax = Math.max(a[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            if (a[i] < currentMin) {
                currentMin = a[i];
            } else if (a[i] > currentMax) {
                currentMax = a[i];
            }
        }

        return new Pair<>(currentMin, currentMax);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        double[] a = in.readAllDoubles();

        Stopwatch timer = new Stopwatch();
        Pair<Double, Double> closestPair = farthest(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(closestPair.getKey() + " " + closestPair.getValue());
    }
}
