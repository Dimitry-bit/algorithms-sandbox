/* 2.3.18 Median-of-3 partitioning. Add median-of-3 partitioning to quicksort, as described
in the text (see page 296). Run doubling tests to determine the effectiveness of the change. */

package prj.algs4.chapter2.section3;

import edu.princeton.cs.algs4.StdRandom;
import prj.algs4.chapter2.section1.InsertionSort;

public class QuickSortCutoff {

    private static final int CUTOFF = 15;

    private QuickSortCutoff() {
    }

    public static void sort(Comparable[] a) {
        if (a.length <= 0) {
            return;
        }

        StdRandom.shuffle(a);

        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        exch(a, maxIndex, a.length - 1);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        if (hi - lo == CUTOFF) {
            InsertionSort.sort(a, lo, hi);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        if (less(a[hi], a[lo])) {
            exch(a, hi, lo);
        }
        if (less(a[mid], a[lo])) {
            exch(a, mid, lo);
        }
        if (less(a[hi], a[mid])) {
            exch(a, mid, hi);
        }

        exch(a, mid, lo);
        Comparable v = a[lo];

        int i = lo;
        int j = hi + 1;

        while (true) {
            // @formatter:off
            while (less(a[++i], v));
            while (less(v, a[--j]));
            // @formatter:on

            if (j <= i) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
