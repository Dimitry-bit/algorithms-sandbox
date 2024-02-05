/* 2.1.16 Certification. Write a check() method that calls sort() for a given array and
returns true if sort() puts the array in order and leaves the same set of objects in the
array as were there initially, false otherwise. Do not assume that sort() is restricted to
move data only with exch(). You may use Arrays.sort() and assume that it is correct. */

package prj.algs4.chapter2.section1;

import java.util.Arrays;
import java.util.HashMap;

public class Certification {
    private Certification() {
    }

    public static boolean check(Comparable[] a) {
        HashMap<Comparable, Integer> valuesMap = new HashMap<>();

        for (Comparable c : a) {
            valuesMap.put(c, valuesMap.getOrDefault(c, 0) + 1);
        }

        Arrays.sort(a);

        for (Comparable c : a) {
            if (!valuesMap.containsKey(c)) {
                break;
            }

            int count = valuesMap.get(c);

            if (count == 1) {
                valuesMap.remove(c);
            } else {
                valuesMap.put(c, count - 1);
            }
        }

        return (valuesMap.size() == 0) ? true : false;
    }
}
