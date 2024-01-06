package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackLinkedListTest {

    @Test
    public void stackLinkedList_createStack_sizeShouldBeZero() {
        StackLinkedList<String> s = new StackLinkedList<>();

        Assertions.assertEquals(0, s.size());
        Assertions.assertTrue(s.isEmpty());
    }

    @Test
    public void stackLinkedList_push() {
        StackLinkedList<String> s = new StackLinkedList<>();

        s.push("Front");

        Assertions.assertEquals(1, s.size());
        Assertions.assertFalse(s.isEmpty());
    }

    @Test
    public void stackLinkedList_pop_shouldReturnPoppedItem() {
        StackLinkedList<String> s = new StackLinkedList<>();
        s.push("First");

        Assertions.assertEquals("First", s.pop());
        Assertions.assertEquals(0, s.size());
        Assertions.assertTrue(s.isEmpty());
    }

    @Test
    public void stackLinkedList_peek_shouldReturnTopValueWithoutPopping() {
        StackLinkedList<String> s = new StackLinkedList<>();
        s.push("Needle");

        String value = s.peek();

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(1, s.size());
        Assertions.assertFalse(s.isEmpty());
    }

    public void stackLinkedList_popOnEmptyStack_shouldThrowNoSuchElement() {
        StackLinkedList<String> s = new StackLinkedList<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, s::pop);
    }
}
