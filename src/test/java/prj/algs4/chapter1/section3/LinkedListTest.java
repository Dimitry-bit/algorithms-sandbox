package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void linkedList_createList_sizeShouldBeZero() {
        LinkedList<String> list = new LinkedList<>();

        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void linkedList_insertFront() {
        LinkedList<String> list = new LinkedList<>();
        list.insertBack("Back");

        list.insertFront("Front");
        int index = list.find("Front");

        Assertions.assertEquals(0, index);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void linkedList_insertBack() {
        LinkedList<String> list = new LinkedList<>();
        list.insertFront("Front");

        list.insertBack("Back");

        int index = list.find("Back");

        Assertions.assertEquals(1, index);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void linkedList_insertAt() {
        LinkedList<String> list = new LinkedList<>();
        list.insertFront("Front");
        list.insertBack("Back");

        list.insertAt("Needle", 1);
        int index = list.find("Needle");

        Assertions.assertEquals(1, index);
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void linkedList_isEmpty_shouldReturnSizeAndIsNotEmpty() {
        LinkedList<String> list = new LinkedList<>();
        list.insertBack("First");

        Assertions.assertEquals(1, list.size());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void linkedList_removeFront_shouldReturnHeadItem() {
        LinkedList<String> list = new LinkedList<>();
        list.insertBack("Back");

        list.insertFront("Front");
        String value = list.removeFront();

        Assertions.assertEquals("Front", value);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void linkedList_removeBack_shouldReturnTailItem() {
        LinkedList<String> list = new LinkedList<>();
        list.insertFront("Front");

        list.insertBack("Back");
        String value = list.removeBack();

        Assertions.assertEquals("Back", value);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void linkedList_removeAt_shouldReturnItemAt() {
        LinkedList<String> list = new LinkedList<>();
        list.insertFront("Front");
        list.insertBack("Back");

        list.insertAt("Needle", 1);
        String value = list.removeAt(1);

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void linkedList_removeElement_shouldReturnRemovedElementCount() {
        LinkedList<String> list = new LinkedList<>();
        list.insertBack("Target");

        int count = list.remove("Target");

        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(1, count);
    }

    @Test
    public void linkedList_find_shouldReturnItemIndex() {
        LinkedList<String> list = new LinkedList<>();
        list.insertFront("Needle");

        int index = list.find("Needle");

        Assertions.assertEquals(0, index);
    }

    @Test
    public void linkedList_remove_shouldThrowNoSuchElement() {
        LinkedList<String> list = new LinkedList<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, list::removeFront);
        Assertions.assertThrowsExactly(NoSuchElementException.class, list::removeBack);
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> list.remove("Needle"));
        Assertions.assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.removeAt(0));
    }
}
