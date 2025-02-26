package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest  {
    private MinMaxStackImpl minMaxStack;
    private static int elementPush = 1;
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
        minMaxStack.push(elementPush);
        assertEquals(1, minMaxStack.peek());
    }
    @Test
    public void testPop() {
        minMaxStack.push(elementPush);
        assertEquals(1,minMaxStack.pop());
    }
    @Test
    public void testPeek() {
        minMaxStack.push(elementPush);
        minMaxStack.push(2);
        minMaxStack.push(3);
        assertEquals(3,minMaxStack.peek());
    }
    @Test
    public void testGetMin() {
        minMaxStack.push(2);
        minMaxStack.push(3);
        minMaxStack.push(elementPush);
        assertEquals(1,minMaxStack.getMin());
        assertEquals(1,minMaxStack.pop());
        assertEquals(2,minMaxStack.getMin());
    }
    @Test
    public void testGetMax() {
        minMaxStack.push(elementPush);
        minMaxStack.push(2);
        minMaxStack.push(3);
        assertEquals(3, minMaxStack.getMax());
        assertEquals(3, minMaxStack.pop());
        assertEquals(2, minMaxStack.getMax());
    }
    @Test
    public void testIsEmpty(){
        minMaxStack.push(elementPush);
        assertFalse(minMaxStack.isEmpty());
        assertEquals(1,minMaxStack.pop());
        assertTrue(minMaxStack.isEmpty());
    }
    @Test
    public void testSize(){
        minMaxStack.push(elementPush);
        minMaxStack.push(2);
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
}