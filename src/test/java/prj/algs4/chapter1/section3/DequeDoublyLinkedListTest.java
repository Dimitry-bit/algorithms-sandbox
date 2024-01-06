package prj.algs4.chapter1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class DequeDoublyLinkedListTest {

    @Test
    public void dequeDoublyLinkedList_insertion() {
        DequeDoublyLinkedList<String> deque = new DequeDoublyLinkedList<>();
        deque.pushLeft("Left");
        deque.pushRight("Right");
        Assertions.assertEquals("Left", deque.popLeft());
        Assertions.assertEquals("Right", deque.popLeft());
    }

    @Test
    public void dequeDoublyLinkedList_insertion_size() {
        DequeDoublyLinkedList<String> deque = new DequeDoublyLinkedList<>();
        deque.pushRight("Right");
        Assertions.assertEquals(1, deque.size());
        Assertions.assertFalse(deque.isEmpty());
        deque.popRight();
        Assertions.assertEquals(0, deque.size());
        Assertions.assertTrue(deque.isEmpty());
    }

    @Test
    public void dequeDoublyLinkedList_popWhenEmpty_shouldThrowNoSuchElementException() {
        DequeDoublyLinkedList<String> deque = new DequeDoublyLinkedList<>();
        Assertions.assertThrowsExactly(NoSuchElementException.class, deque::popLeft);
        Assertions.assertThrowsExactly(NoSuchElementException.class, deque::popRight);
    }
}
