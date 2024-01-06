package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueResizingArrayTest {

    @Test
    public void queueResizingArray_createQueue_sizeShouldBeZero() {
        QueueResizingArray<String> q = new QueueResizingArray<>();

        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    public void queueResizingArray_enqueue() {
        QueueResizingArray<String> q = new QueueResizingArray<>();

        q.enqueue("Front");

        Assertions.assertEquals(1, q.size());
        Assertions.assertFalse(q.isEmpty());
    }

    @Test
    public void queueResizingArray_dequeue_shouldReturnPoppedItem() {
        QueueResizingArray<String> q = new QueueResizingArray<>();
        q.enqueue("First");

        Assertions.assertEquals("First", q.dequeue());
        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    public void queueResizingArray_peek_shouldReturnTopValueWithoutPopping() {
        QueueResizingArray<String> q = new QueueResizingArray<>();
        q.enqueue("Needle");

        String value = q.peek();

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(1, q.size());
        Assertions.assertFalse(q.isEmpty());
    }

    public void queueResizingArray_dequeOnEmptyQueue_shouldThrowNoSuchElement() {
        QueueResizingArray<String> q = new QueueResizingArray<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, q::dequeue);
    }
}
