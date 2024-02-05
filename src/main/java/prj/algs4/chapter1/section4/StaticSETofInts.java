/* 1.4.11 Add an instance method howMany() to StaticSETofInts (page 99) that finds the
number of occurrences of a given key in time proportional to log N in the worst case. */

package prj.algs4.chapter1.section4;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) { // Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public int howMany(int key) {
        int left = BinarySearch.BinarySearchSmallestIndex(a, key);
        int right = BinarySearch.BinarySearchLargestIndex(a, key);
        int diff = right - left;

        return ((right == -1) || (left == -1)) ? 0 : (diff + 1);
    }
}
