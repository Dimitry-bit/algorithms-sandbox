/* 2.1.24 Insertion sort with sentinel. Develop an implementation of insertion sort that
eliminates the j>0 test in the inner loop by first putting the smallest item into position.
Use SortCompare to evaluate the effectiveness of doing so. Note : It is often possible to
avoid an index-out-of-bounds test in this way—the element that enables the test to be
eliminated is known as a sentinel. */

package prj.algs4.chapter2.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSortSentinel {

    private InsertionSortSentinel() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;

        // Put smallest element in the 0 position
        {
            int min = 0;
            for (int i = 1; i < N; i++) {
                if (less(a[i], a[min])) {
                    min = i;
                }
            }
            exch(a, 0, min);
        }

        for (int i = 1; i < N; i++) {
            for (int j = i; less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
