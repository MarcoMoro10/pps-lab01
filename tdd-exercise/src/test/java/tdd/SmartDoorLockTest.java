package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartDoorLockTest {

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
    public void testInitialState() {
        assertFalse(smartDoorLock.isLocked());
        assertFalse(smartDoorLock.isBlocked());
        assertEquals(0,smartDoorLock.getFailedAttempts());
    }
    @Test
    public void testSetPinOnlyWhenNoPinSet(){
        smartDoorLock.setPin(1234);
        assertThrows(IllegalStateException.class, () -> smartDoorLock.setPin(5678));
    }
    @Test
    public void testLockWithoutPinThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
        assertEquals("Cannot lock without setting a PIN", exception.getMessage());
    }
    @Test
    public void testLockWithPinSet() {
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }
    @Test
    public void testUnlock(){
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
        smartDoorLock.unlock(1234);
        assertFalse(smartDoorLock.isLocked());

    }
    @Test
    public void testUnlockWithWrongPin(){
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        smartDoorLock.unlock(0000);
        assertTrue(smartDoorLock.isLocked());
        assertEquals(1,smartDoorLock.getFailedAttempts());
    }
    @Test
    public void testUnlockWithWrongPinMultipleTimes(){
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        for(int i=0; i<= smartDoorLock.getMaxAttempts();i++){
            smartDoorLock.unlock(0000);
        }
        assertTrue(smartDoorLock.isBlocked());
    }
    @Test
    void testCannotUnlockWhenBlocked() {
        smartDoorLock.setPin(1234);
        smartDoorLock.lock();
        for (int i = 0; i <= smartDoorLock.getMaxAttempts(); i++) {
            smartDoorLock.unlock(0000);
        }
        smartDoorLock.unlock(1234);
        assertTrue(smartDoorLock.isBlocked());
    }

}
