/* 2.2.11 Improvements. Implement the three improvements to mergesort that are described 
in the text on page 275: Add a cutoff for small subarrays, test whether the array is
already in order, and avoid the copy by switching arguments in the recursive code. */

package prj.algs4.chapter2.section2;

import prj.algs4.chapter2.section1.InsertionSort;

public class MergeSortImproved {

    private static final int CUTOFF = 15;

    private MergeSortImproved() {
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        if (hi - lo <= CUTOFF) {
            InsertionSort.sort(a, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;

            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);

            if (a[mid].compareTo(a[mid + 1]) > 0) {
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
