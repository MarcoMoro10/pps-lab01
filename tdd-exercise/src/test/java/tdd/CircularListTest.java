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
        assertEquals(5, circularQueue.peek());
    }
}
