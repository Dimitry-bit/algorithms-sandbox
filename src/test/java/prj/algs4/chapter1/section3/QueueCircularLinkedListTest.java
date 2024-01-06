package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueCircularLinkedListTest {

    @Test
    public void queueCircularLinkedList_createQueue_sizeShouldBeZero() {
        QueueCircularLinkedList<String> q = new QueueCircularLinkedList<>();

        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    public void queueCircularLinkedList_enqueue() {
        QueueCircularLinkedList<String> q = new QueueCircularLinkedList<>();

        q.enqueue("Front");

        Assertions.assertEquals(1, q.size());
        Assertions.assertFalse(q.isEmpty());
    }

    @Test
    public void queueCircularLinkedList_dequeue_shouldReturnPoppedItem() {
        QueueCircularLinkedList<String> q = new QueueCircularLinkedList<>();
        q.enqueue("First");

        Assertions.assertEquals("First", q.dequeue());
        Assertions.assertEquals(0, q.size());
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    public void queueCircularLinkedList_peek_shouldReturnTopValueWithoutPopping() {
        QueueCircularLinkedList<String> q = new QueueCircularLinkedList<>();
        q.enqueue("Needle");

        String value = q.peek();

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(1, q.size());
        Assertions.assertFalse(q.isEmpty());
    }

    public void queueCircularLinkedList_dequeOnEmptyQueue_shouldThrowNoSuchElement() {
        QueueCircularLinkedList<String> q = new QueueCircularLinkedList<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, q::dequeue);
    }
}
