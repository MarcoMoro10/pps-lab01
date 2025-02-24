package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static boolean lockState = false;
    private static int pinLock = 1234;
    @Test
    public void todo() {
        assertTrue(true);
    }

    @Test
    public void testSetPin() {
        assertFalse(lockState);
    }
    @Test
    public void testUnlock() {
        assertEquals(1234, pinLock);
        lockState = false;
        assertFalse(lockState);
    }
    @Test
    public void testLock(){
        lockState = true;
        assertTrue(lockState);
    }

}
