package prj.algs4.chapter2.section2;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdRandom;

public class MergeShuffle {

    private MergeShuffle() {
    }

    public static void shuffle(Object[] a) {
        Double[] r = new Double[a.length];

        for (int i = 0; i < a.length; i++) {
            r[i] = StdRandom.uniformDouble();
        }

        int[] index = Merge.indexSort(r);
        for (int i = 0; i < a.length; i++) {
            Object tmp = a[i];
            a[i] = a[index[i]];
            a[index[i]] = tmp;
        }
    }
}
