
package prj.algs4.chapter1.section4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * TwoSumFast
 * Does not handle zero edge case
 */
public class TwoSumFast {
    private TwoSumFast() {
    }

    public static void printAll(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            int res = Arrays.binarySearch(a, -a[i]);
            if (res > i) {
                System.out.println(a[i] + " " + -a[i]);
            }
        }
    }

    public static int count(int[] a) {
        int count = 0;

        for (int i = 0; i < a.length; ++i) {
            int res = Arrays.binarySearch(a, -a[i]);
            if (res > i) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Arrays.sort(a);

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
