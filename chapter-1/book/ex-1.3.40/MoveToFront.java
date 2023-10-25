/* 1.3.40 Move-to-front. Read in a sequence of characters from standard input and
maintain the characters in a linked list with no duplicates. When you read in a previ-
ously unseen character, insert it at the front of the list. When you read in a duplicate
character, delete it from the list and reinsert it at the beginning. Name your program
MoveToFront: it implements the well-known move-to-front strategy, which is useful for
caching, data compression, and many other applications where items that have been
recently accessed are more likely to be reaccessed. */

import java.util.NoSuchElementException;

// NOTE: Array is a better choice
public final class MoveToFront {
    // NOTE: All printable characters
    private static final char rangeStart = ' ';
    private static final char rangeEnd = '~';

    public static int[] encode(String src) {
        DoublyLinkedList<Character> list = new DoublyLinkedList<Character>();
        for (char c = rangeStart; c <= rangeEnd; c++) {
            list.insertBack(c);
        }

        QueueResizingArray<Integer> queue = new QueueResizingArray<>();
        for (int i = 0; i < src.length(); ++i) {
            char c = src.charAt(i);
            int index = list.find(c);
            if (index == -1) {
                throw new NoSuchElementException();
            }
            queue.enqueue(index);
            list.remove(c);
            list.insertFront(c);
        }

        int[] output = new int[0];
        if (!queue.isEmpty()) {
            output = new int[queue.size()];
            int i = 0;
            while (!queue.isEmpty()) {
                output[i++] = queue.dequeue();
            }
        }

        return output;
    }

    public static String decode(int[] inputEncoded) {
        DoublyLinkedList<Character> list = new DoublyLinkedList<Character>();
        for (char c = rangeStart; c <= rangeEnd; c++) {
            list.insertBack(c);
        }

        QueueResizingArray<Character> queue = new QueueResizingArray<>();
        for (int n : inputEncoded) {
            char c = list.removeAt(n);
            list.insertFront(c);
            queue.enqueue(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.dequeue());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            if (i != 0) {
                System.out.println();
            }

            System.out.printf("String: \"%s\"\n", args[i]);
            int[] output = MoveToFront.encode(args[i]);
            System.out.print("Encoded: [");
            for (int j = 0; j < output.length; ++j) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.printf("\"%d\"", output[j]);
            }
            System.out.println("]");
            System.out.printf("Decoded: \"%s\"\n", MoveToFront.decode(output));
        }
    }
}