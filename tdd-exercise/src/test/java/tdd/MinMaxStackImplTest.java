package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest  {
    private MinMaxStackImpl minMaxStack;
    private static int firstElementPush = 1;
    private static int secondElementPush = 2;
    private static int thirdElementPush = 3;
    @BeforeEach
    void setUp(){
        minMaxStack = new MinMaxStackImpl();
    }
    @Test
    public void todo() {
        assertTrue(true);
    }

    @Test
    public void testPush() {
        minMaxStack.push(firstElementPush);
        assertEquals(1, minMaxStack.peek());
    }
    @Test
    public void testPop() {
        minMaxStack.push(firstElementPush);
        assertEquals(1,minMaxStack.pop());
    }
    @Test
    public void testPeek() {
        minMaxStack.push(firstElementPush);
        minMaxStack.push(secondElementPush);
        minMaxStack.push(thirdElementPush);
        assertEquals(3,minMaxStack.peek());
    }
    @Test
    public void testGetMin() {
        minMaxStack.push(secondElementPush);
        minMaxStack.push(thirdElementPush);
        minMaxStack.push(firstElementPush);
        assertEquals(1,minMaxStack.getMin());
        assertEquals(1,minMaxStack.pop());
        assertEquals(2,minMaxStack.getMin());
    }
    @Test
    public void testGetMax() {
        minMaxStack.push(firstElementPush);
        minMaxStack.push(secondElementPush);
        minMaxStack.push(thirdElementPush);
        assertEquals(3, minMaxStack.getMax());
        assertEquals(3, minMaxStack.pop());
        assertEquals(2, minMaxStack.getMax());
    }
    @Test
    public void testIsEmpty(){
        minMaxStack.push(firstElementPush);
        assertFalse(minMaxStack.isEmpty());
        assertEquals(1,minMaxStack.pop());
        assertTrue(minMaxStack.isEmpty());
    }
    @Test
    public void testSize(){
        minMaxStack.push(firstElementPush);
        minMaxStack.push(secondElementPush);
        assertEquals(2, minMaxStack.size());
    }
    @Test
    public void testPopWithEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }
    @Test
    public void testPeekWithEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }
    @Test
    public void testGetMinWithEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
    }
    @Test
    public void testGetMaxWithEmptyStack(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMax());
    }
}