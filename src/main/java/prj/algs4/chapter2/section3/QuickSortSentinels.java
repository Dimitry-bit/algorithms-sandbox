/* 2.3.17 Sentinels. Modify the code in Algorithm 2.5 to remove both bounds checks
in the inner while loops. The test against the left end of the subarray is redundant since
the partitioning item acts as a sentinel (v is never less than a[lo]). To enable removal of
the other test, put an item whose key is the largest in the whole array into a[length-1]
just after the shuffle. This item will never move (except possibly to be swapped with an
item having the same key) and will serve as a sentinel in all subarrays involving the end
of the array. Note : When sorting interior subarrays, the leftmost entry in the subarray
to the right serves as a sentinel for the right end of the subarray. */

package prj.algs4.chapter2.section3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSortSentinels {

    private QuickSortSentinels() {
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

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

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
