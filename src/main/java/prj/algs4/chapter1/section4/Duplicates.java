/*
 * 1.4.12 Write a program that, given two sorted arrays of N int values, prints
 * all ele- ments that appear in both arrays, in sorted order. The running time
 * of your program should be proportional to N in the worst case.
 */

package prj.algs4.chapter1.section4;

import java.util.Arrays;

public class Duplicates {
    private Duplicates() {
    }

    public static void print(int[] a, int[] b) {
        int[] src = null;
        int[] other = null;

        if (a.length < b.length) {
            src = a;
            other = b;
        } else {
            src = b;
            other = a;
        }

        for (int element : src) {
            if (Arrays.binarySearch(other, element) >= 0) {
                System.out.println(element);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 1, 3, 5, 6, 7, 8 };
        print(a, b);
    }
}
