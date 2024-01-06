package prj.algs4.chapter1.section3;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RingBufferTest {

    @Test
    public void ringBuffer_createBuffer_countShouldZeroAndCapacityShouldBeN() {
        int capacity = 3;
        RingBuffer<String> ringBuffer = new RingBuffer<>(capacity);

        Assertions.assertEquals(capacity, ringBuffer.capacity());
        Assertions.assertEquals(0, ringBuffer.count());
        Assertions.assertTrue(ringBuffer.isEmpty());
        Assertions.assertFalse(ringBuffer.isFull());
    }

    @Test
    public void ringBuffer_createBufferWithInvalidSize_shouldThrowException() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new RingBuffer<>(1));
    }

    @Test
    public void ringBuffer_enqueue_shouldReturnTrue() {
        RingBuffer<String> ringBuffer = new RingBuffer<>(3);

        boolean value = ringBuffer.enqueue("Front");

        Assertions.assertTrue(value);
        Assertions.assertEquals(1, ringBuffer.count());
        Assertions.assertFalse(ringBuffer.isEmpty());
        Assertions.assertFalse(ringBuffer.isFull());
    }

    @Test
    public void ringBuffer_enqueueOnFullBuffer_shouldReturnFalse() {
        RingBuffer<String> ringBuffer = new RingBuffer<>(3);
        ringBuffer.enqueue("1");
        ringBuffer.enqueue("2");
        ringBuffer.enqueue("3");

        boolean value = ringBuffer.enqueue("3");

        Assertions.assertFalse(value);
        Assertions.assertEquals(3, ringBuffer.count());
        Assertions.assertFalse(ringBuffer.isEmpty());
        Assertions.assertTrue(ringBuffer.isFull());
    }

    @Test
    public void ringBuffer_dequeue_shouldReturnPoppedItem() {
        RingBuffer<String> ringBuffer = new RingBuffer<>(3);
        ringBuffer.enqueue("First");

        Assertions.assertEquals("First", ringBuffer.dequeue());
        Assertions.assertEquals(0, ringBuffer.count());
        Assertions.assertTrue(ringBuffer.isEmpty());
        Assertions.assertFalse(ringBuffer.isFull());
    }

    @Test
    public void ringBuffer_peek_shouldReturnTopValueWithoutPopping() {
        RingBuffer<String> ringBuffer = new RingBuffer<>(3);
        ringBuffer.enqueue("Needle");

        String value = ringBuffer.peek();

        Assertions.assertEquals("Needle", value);
        Assertions.assertEquals(1, ringBuffer.count());
        Assertions.assertFalse(ringBuffer.isEmpty());
        Assertions.assertFalse(ringBuffer.isFull());
    }

    @Test
    public void ringBuffer_dequeueOnEmptyBuffer_shouldThrowNoSuchElement() {
        RingBuffer<String> ringBuffer = new RingBuffer<>(3);

        Assertions.assertThrowsExactly(NoSuchElementException.class, ringBuffer::dequeue);
        Assertions.assertThrowsExactly(NoSuchElementException.class, ringBuffer::peek);
    }

}
