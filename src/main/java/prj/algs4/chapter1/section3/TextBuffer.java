/* 1.3.44 Text editor buffer. Develop a data type for a buffer in a text editor that imple-
ments the following API: */

package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

public class TextBuffer {
    private final StackLinkedList<Character> leftStack;
    private final StackLinkedList<Character> rightStack;

    public TextBuffer() {
        leftStack = new StackLinkedList<>();
        rightStack = new StackLinkedList<>();
    }

    public boolean isEmpty() {
        return (leftStack.isEmpty() && rightStack.isEmpty());
    }

    public int size() {
        return (leftStack.size() + rightStack.size());
    }

    public int getPosition() {
        return leftStack.size();
    }

    public void insert(char c) {
        leftStack.push(c);
    }

    public void insert(String src) {
        char[] charArray = src.toCharArray();
        for (char c : charArray) {
            insert(c);
        }
    }

    public char delete() {
        if (leftStack.isEmpty()) {
            throw new NoSuchElementException("Left stack is empty.");
        }

        return leftStack.pop();
    }

    public void left(int k) {
        if (k < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + k + ", size is " + leftStack.size());
        }

        while (k-- > 0 && !leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
    }

    public void right(int k) {
        if (k < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + k + ", size is " + leftStack.size());
        }

        while (k-- > 0 && !rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
    }

    public String getBufferContent() {
        StringBuilder sb = new StringBuilder();
        StackLinkedList<Character> s = new StackLinkedList<>();

        for (char c : leftStack) {
            s.push(c);
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        for (char c : rightStack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String toString() {
        return getBufferContent();
    }

    public static void main(String[] args) {
        TextBuffer tb = new TextBuffer();

        for (String argv : args) {
            switch (argv) {
                case "<" -> tb.left(1);
                case ">" -> tb.right(1);
                case "-" -> tb.delete();
                default -> tb.insert(argv);
            }
        }

        System.out.println(tb);
    }
}
