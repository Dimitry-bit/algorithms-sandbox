package prj.algs4.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public final class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        for (int i = 0; i < n; ++i) {
            StdOut.println(StdRandom.uniformInt(-max, max));
        }
    }
}