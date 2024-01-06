package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextBufferTest {

    @Test
    public void textBuffer_insertChar() {
        TextBuffer tBuffer = new TextBuffer();
        tBuffer.insert("0");

        Assertions.assertEquals("0", tBuffer.getBufferContent());
        Assertions.assertEquals(1, tBuffer.size());
        Assertions.assertFalse(tBuffer.isEmpty());
    }

    @Test
    public void textBuffer_left() {
        TextBuffer tBuffer = new TextBuffer();
        tBuffer.insert("abc");
        tBuffer.left(1);

        int position = tBuffer.getPosition();

        Assertions.assertEquals(2, position);
    }

    @Test
    public void textBuffer_right() {
        TextBuffer tBuffer = new TextBuffer();
        tBuffer.insert("abc");
        tBuffer.left(tBuffer.size());

        tBuffer.right(1);

        int position = tBuffer.getPosition();

        Assertions.assertEquals(1, position);
    }

    @Test
    public void textBuffer_invalidMovement_shouldThrowException() {
        TextBuffer tBuffer = new TextBuffer();

        Assertions.assertThrowsExactly(IndexOutOfBoundsException.class, () -> tBuffer.left(-1));
        Assertions.assertThrowsExactly(IndexOutOfBoundsException.class, () -> tBuffer.right(-1));
    }

    @Test
    public void textBuffer_leftOnBeginning_shouldNotChangePosition() {
        TextBuffer tBuffer = new TextBuffer();
        tBuffer.insert("abc");
        tBuffer.left(tBuffer.size());

        int expected = tBuffer.getPosition();
        tBuffer.left(1);
        int value = tBuffer.getPosition();

        Assertions.assertEquals(expected, value);
    }

    @Test
    public void textBuffer_rightOnEnd_shouldNotChangePosition() {
        TextBuffer tBuffer = new TextBuffer();
        tBuffer.insert("abc");

        int expected = tBuffer.getPosition();
        tBuffer.right(1);
        int value = tBuffer.getPosition();

        Assertions.assertEquals(expected, value);
    }

    @Test
    public void textBuffer_deleteChar_shouldReturnDeletedCharacter() {
        TextBuffer tBuffer = new TextBuffer();
        tBuffer.insert('a');

        char value = tBuffer.delete();

        Assertions.assertEquals('a', value);
        Assertions.assertEquals(0, tBuffer.size());
        Assertions.assertTrue(tBuffer.isEmpty());
    }

    @Test
    public void textBuffer_deleteOnEmptyBuffer_shouldThrowNoSuchElement() {
        TextBuffer tBuffer = new TextBuffer();

        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> tBuffer.delete());
    }
}
