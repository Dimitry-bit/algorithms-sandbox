/*
 * 2.1.11 Implement a version of shellsort that keeps the increment sequence in
 * an array, rather than computing it.
 */

package prj.algs4.chapter2.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellSortIncSeq {
    private ShellSortIncSeq() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int[] seq = new int[N / 3];

        seq[0] = 1;
        for (int i = 1; i < seq.length; i++) {
            seq[i] = 3 * seq[i - 1] + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }

        for (int i = seq.length - 1; i >= 0; i--) {
            int h = seq[i];
            for (int j = h; j < N; j++) {
                for (int k = j; k >= h && less(a[k], a[k - 1]); k -= h) {
                    exch(a, k, k - 1);
                }
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
