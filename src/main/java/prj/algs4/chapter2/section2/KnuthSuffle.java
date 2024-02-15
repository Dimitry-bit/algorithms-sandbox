package prj.algs4.chapter2.section2;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthSuffle {

    private KnuthSuffle() {
    }

    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = StdRandom.uniformInt(0, i + 1);

            Object tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
}
