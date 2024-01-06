package prj.algs4.chapter1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class DoublyLinkedListTest {

    @Test
    public void doublyLinkedList_createList_sizeShouldBeZero() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();

        Assertions.assertEquals(0, ll.size());
        Assertions.assertTrue(ll.isEmpty());
    }

    @Test
    public void doublyLinkedList_insertFront() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("Back");

        ll.insertFront("Front");

        Assertions.assertEquals(0, ll.find("Front"));
        Assertions.assertEquals(2, ll.size());
    }

    @Test
    public void doublyLinkedList_insertBack() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertFront("Front");

        ll.insertBack("Back");

        Assertions.assertEquals(1, ll.find("Back"));
        Assertions.assertEquals(2, ll.size());
    }

    @Test
    public void doublyLinkedList_insertAfter() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("First");
        ll.insertBack("Second");
        ll.insertBack("Third");

        ll.insertAfter("After", 1);

        Assertions.assertEquals(2, ll.find("After"));
        Assertions.assertEquals(4, ll.size());
    }

    @Test
    public void doublyLinkedList_insertBefore() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("First");
        ll.insertBack("Second");
        ll.insertBack("Third");

        ll.insertBefore("Before", 1);

        Assertions.assertEquals(1, ll.find("Before"));
        Assertions.assertEquals(4, ll.size());
    }

    @Test
    public void doublyLinkedList_find_shouldReturnItemIndex() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("Needle");

        Assertions.assertEquals(0, ll.find("Needle"));
    }

    @Test
    public void doublyLinkedList_removeBack_shouldReturnTailItem() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertFront("Front");

        ll.insertBack("Back");
        String value = ll.removeBack();

        Assertions.assertEquals("Back", value);
        Assertions.assertEquals(1, ll.size());
    }

    @Test
    public void doublyLinkedList_removeFront_shouldReturnHeadItem() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("Back");

        ll.insertFront("Front");
        String value = ll.removeFront();

        Assertions.assertEquals("Front", value);
        Assertions.assertEquals(1, ll.size());
    }

    @Test
    public void doublyLinkedList_removeElement_shouldReturnRemovedElementCount() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("Target");

        int count = ll.remove("Target");

        Assertions.assertEquals(0, ll.size());
        Assertions.assertEquals(1, count);
    }

    @Test
    public void doublyLinkedList_isEmpty() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();
        ll.insertBack("Target");

        Assertions.assertFalse(ll.isEmpty());
    }

    @Test
    public void doublyLinkedList_remove_shouldThrowNoSuchElement() {
        DoublyLinkedList<String> ll = new DoublyLinkedList<>();

        Assertions.assertThrowsExactly(NoSuchElementException.class, ll::removeFront);
        Assertions.assertThrowsExactly(NoSuchElementException.class, ll::removeBack);
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> ll.remove("Needle"));
        Assertions.assertThrowsExactly(IndexOutOfBoundsException.class, () -> ll.removeAt(0));
    }
}
