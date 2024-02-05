/*
 * 1.4.15 Faster 3-sum. As a warmup, develop an implementation TwoSumFaster that
 * uses a linear algorithm to count the pairs that sum to zero after the array
 * is sorted (in- stead of the binary-search-based linearithmic algorithm). Then
 * apply a similar idea to develop a quadratic algorithm for the 3-sum problem.
 */

package prj.algs4.chapter1.section4;

import java.util.Arrays;
import java.util.Hashtable;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * ThreeSumFaster
 * Does not handle duplicates
 */
public class ThreeSumFaster {
    private ThreeSumFaster() {
    }

    public static void printAll(int[] a) {
        Hashtable<Integer, Integer> freqTable = indexArray(a);

        for (int i = 0; i < a.length; ++i) {
            if (a[i] > -a[i]) {
                continue;
            }

            if (freqTable.containsKey(-a[i])) {
                System.out.println(a[i] + " " + -a[i]);
            }
        }
    }

    public static int count(int[] a) {
        int count = 0;
        boolean isZeroHandled = false;
        Hashtable<Integer, Integer> freqTable = indexArray(a);

        for (int i = 0; i < a.length; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int sum = a[i] + a[j];
                // Handle zero edge case
                if ((a[i] == 0) && (a[j] == 0) && !isZeroHandled) {
                    int zeroFreq = freqTable.get(0);
                    // C(freq, 3)
                    count += (zeroFreq * (zeroFreq - 1) * (zeroFreq - 2)) / 6;
                    isZeroHandled = true;
                } else if (a[j] < -sum && freqTable.containsKey(-sum)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static Hashtable<Integer, Integer> indexArray(int[] a) {
        Hashtable<Integer, Integer> freqTable = new Hashtable<>();

        for (int i = 0; i < a.length; ++i) {
            int freq = freqTable.getOrDefault(a[i], 0);
            freqTable.put(a[i], freq + 1);
        }

        return freqTable;
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
