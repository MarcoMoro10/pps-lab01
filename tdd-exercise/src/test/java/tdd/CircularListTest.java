package tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularQueueImpl circularQueue;
    private static int firstValue = 5;
    private static int secondValue = 7;
    private static int thirdValue = 9;
    private static int fourthValue = 8;
    private static int firstValueExecpeted =5;
    private static int initialSize =0;
    private static int twoElmentsSize =2;
    private static int oneElementSize =1;


    @BeforeEach
    void setUp() {
        circularQueue = new CircularQueueImpl();
    }
    @Test
    public void todo() {
        assertTrue(true);
    }
    @Test
    public void testEnqueue() {
        circularQueue.enqueue(firstValue);
        assertEquals(firstValueExecpeted, circularQueue.peek());
    }
    @Test
    public void testDequeue() {
        circularQueue.enqueue(firstValue);
        circularQueue.enqueue(secondValue);
        assertEquals(firstValue, circularQueue.dequeue());
    }
    @Test
    public void testPeek() {
        circularQueue.enqueue(firstValue);
        circularQueue.enqueue(secondValue);
        assertEquals(firstValue, circularQueue.peek());
    }
    @Test
    public void testIsEmpty() {
        assertTrue(circularQueue.isEmpty());
    }
    @Test
    public void testIsFull() {
        circularQueue.enqueue(firstValue);
        circularQueue.enqueue(secondValue);
        circularQueue.enqueue(thirdValue);
        assertTrue(circularQueue.isFull());
    }
    @Test
    public void testOverWrite(){
        circularQueue.enqueue(firstValue);
        circularQueue.enqueue(secondValue);
        circularQueue.enqueue(thirdValue);
        circularQueue.enqueue(fourthValue);
        assertEquals(secondValue, circularQueue.dequeue());
        assertEquals(thirdValue, circularQueue.dequeue());
        assertEquals(fourthValue, circularQueue.dequeue());
    }
    @Test
    public void testSize(){
        assertEquals(initialSize, circularQueue.size());
        circularQueue.enqueue(firstValue);
        circularQueue.enqueue(secondValue);
        assertEquals(twoElmentsSize, circularQueue.size());
        circularQueue.dequeue();
        assertEquals(oneElementSize, circularQueue.size());
    }
   @Test
    public void testDequeueEmptyQueueThrowsException(){
        assertThrows(IllegalStateException.class, () -> circularQueue.dequeue());
   }
   @Test
    public void testPeekEmptyQueueThrowsException(){
        assertThrows(IllegalStateException.class, () -> circularQueue.peek());
   }
}
