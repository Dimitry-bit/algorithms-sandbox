/* 1.4.2 Modify ThreeSum to work properly even when the int values are so large that
adding two of them might cause overflow. */

package prj.algs4.chapter1.section4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public final class ThreeSumFastFix {

    public static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public static void printThreeSums(int[] numbers) {
        Arrays.sort(numbers);
        if (containsDuplicates(numbers)) {
            throw new IllegalArgumentException("array contains duplicate integers");
        }

        long[] a = Arrays.stream(numbers).asLongStream().toArray();
        numbers = null;

        for (int i = 0; i < a.length; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) {
                    System.out.println(a[i] + ' ' + a[j] + ' ' + a[k]);
                }
            }
        }
    }

    public static int count(int[] numbers) {
        Arrays.sort(numbers);
        if (containsDuplicates(numbers)) {
            throw new IllegalArgumentException("array contains duplicate integers");
        }

        long[] a = Arrays.stream(numbers).asLongStream().toArray();
        numbers = null;

        int count = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int count = count(a);
        StdOut.println(count);
    }
}