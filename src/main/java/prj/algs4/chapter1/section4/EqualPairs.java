/* 1.4.8 Write a program to determine the number pairs of values in an input file that
are equal. If your first try is quadratic, think again and use Arrays.sort() to develop
a linearithmic solution. */

package prj.algs4.chapter1.section4;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public final class EqualPairs {
    private EqualPairs() {
    }

    public static int count(int[] a) {
        int freq = 1;
        int nPairs = 0;

        Arrays.sort(a);
        for (int i = 1; i < a.length; ++i) {
            if (a[i] == a[i - 1]) {
                freq++;
            } else {
                // Fact(freq) / (Fact(2) * Fact(freq - 2))
                nPairs += (freq * (freq - 1)) / 2;
                freq = 1;
            }
        }
        nPairs += (freq * (freq - 1)) / 2;

        return nPairs;
    }

    public static void main(String[] args) {
        int[] a = new int[args.length];

        for (int i = 0; i < args.length; ++i) {
            a[i] = Integer.parseInt(args[i]);
        }

        StdOut.println(count(a));
    }
}
