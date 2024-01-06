package prj.utils;

import java.util.Iterator;

public final class PrintUtils {
    private PrintUtils() {
    }

    public static <T> void printCollection(Iterable<T> collection) {
        printCollection(collection, "Collection: [", "]\n", ", ");
    }

    public static <T> void printCollection(Iterable<T> collection, String prefix, String suffix, String delimiter) {
        System.out.print(prefix);
        Iterator<T> it = collection.iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            System.out.printf("\"%s\"", it.next().toString());
            if ((hasNext = it.hasNext())) {
                System.out.printf("%s", delimiter);
            }
        }
        System.out.print(suffix);
    }
}
