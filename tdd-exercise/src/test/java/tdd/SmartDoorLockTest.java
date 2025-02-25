package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartDoorLockTest {
    private static boolean lockState = false; //sbloccato
    private static int pinLock = 1234;
    private static int counterAttemps =0;
    private static final int MAX_ATTEMPTS = 5;
    private static int wrongAttempt = 3456 ;
    private SmartDoorLockImpl smartDoorLock;
    @BeforeEach
    void setUp() {
        smartDoorLock = new SmartDoorLockImpl();
    }

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
    @Test
    public void testUnlockFail(){
        lockState = true;
        assertEquals(false, lockState);
    }

}
