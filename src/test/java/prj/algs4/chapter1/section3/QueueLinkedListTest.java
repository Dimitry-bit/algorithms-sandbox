package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueLinkedListTest {

    @Test
    public void queueLinkedList_createQueue_sizeShouldBeZero() {
        QueueLinkedList<String> q = new QueueLinkedList<>();

        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    public void queueLinkedList_enqueue() {
        QueueLinkedList<String> q = new QueueLinkedList<>();

        q.enqueue("Front");

        Assertions.assertEquals(1, q.size());
        Assertions.assertFalse(q.isEmpty());
    }

    @Test
    public void queueLinkedList_dequeue_shouldReturnPoppedItem() {
        QueueLinkedList<String> q = new QueueLinkedList<>();
        q.enqueue("First");

        Assertions.assertEquals("First", q.dequeue());
        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    public void queueLinkedList_peek_shouldReturnTopValueWithoutPopping() {
        QueueLinkedList<String> q = new QueueLinkedList<>();
        q.enqueue("Needle");

        String value = q.peek();

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(1, q.size());
        Assertions.assertFalse(q.isEmpty());
    }

    public void queueLinkedList_dequeOnEmptyQueue_shouldThrowNoSuchElement() {
        QueueLinkedList<String> q = new QueueLinkedList<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, q::dequeue);
    }

}
