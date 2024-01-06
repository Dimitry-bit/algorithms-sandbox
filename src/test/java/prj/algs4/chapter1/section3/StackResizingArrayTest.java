package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackResizingArrayTest {

    @Test
    public void stackResizingArray_createStack_sizeShouldBeZero() {
        StackResizingArray<String> s = new StackResizingArray<>();

        Assertions.assertEquals(0, s.size());
        Assertions.assertTrue(s.isEmpty());
    }

    @Test
    public void stackResizingArray_push() {
        StackResizingArray<String> s = new StackResizingArray<>();

        s.push("Front");

        Assertions.assertEquals(1, s.size());
        Assertions.assertFalse(s.isEmpty());
    }

    @Test
    public void stackResizingArray_pop_shouldReturnPoppedItem() {
        StackResizingArray<String> s = new StackResizingArray<>();
        s.push("First");

        Assertions.assertEquals("First", s.pop());
        Assertions.assertEquals(0, s.size());
        Assertions.assertTrue(s.isEmpty());
    }

    @Test
    public void stackResizingArray_peek_shouldReturnTopValueWithoutPopping() {
        StackResizingArray<String> s = new StackResizingArray<>();
        s.push("Needle");

        String value = s.peek();

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(1, s.size());
        Assertions.assertFalse(s.isEmpty());
    }

    public void stackResizingArray_popOnEmptyStack_shouldThrowNoSuchElement() {
        StackResizingArray<String> s = new StackResizingArray<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, s::pop);
    }

}
