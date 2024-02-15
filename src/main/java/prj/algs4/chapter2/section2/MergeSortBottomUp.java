/* 2.2.9 Use of a static array like aux[] is inadvisable in library software because multiple
clients might use the class concurrently. Give an implementation of Merge that does not
use a static array. Do not make aux[] local to merge() (see the Q&A for this section).
Hint : Pass the auxiliary array as an argument to the recursive sort(). */

package prj.algs4.chapter2.section2;

public class MergeSortBottomUp {

    private MergeSortBottomUp() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
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
