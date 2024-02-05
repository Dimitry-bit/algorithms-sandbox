/* 1.4.10 Modify binary search so that it always returns the element with the smallest
index that matches the search element (and still guarantees logarithmic running time). */

package prj.algs4.chapter1.section4;

public class BinarySearch {

    public static int BinarySearchSmallestIndex(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int index = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                index = mid;
            }
        }

        return index;
    }

    public static int BinarySearchLargestIndex(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int index = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                lo = mid + 1;
                index = mid;
            }
        }

        return index;
    }
}
