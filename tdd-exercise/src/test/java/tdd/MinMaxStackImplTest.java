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

}