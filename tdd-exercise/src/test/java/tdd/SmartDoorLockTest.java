package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartDoorLockTest {

    private SmartDoorLockImpl smartDoorLock;
    private static int pinCode = 1234;
    private static int WrongCode = 0000;
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
        smartDoorLock.setPin(pinCode);
        assertThrows(IllegalStateException.class, () -> smartDoorLock.setPin(5678));
    }
    @Test
    public void testLockWithoutPinThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
        assertEquals("Cannot lock without setting a PIN", exception.getMessage());
    }
    @Test
    public void testLockWithPinSet() {
        smartDoorLock.setPin(pinCode);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }
    @Test
    public void testUnlock(){
        smartDoorLock.setPin(pinCode);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
        smartDoorLock.unlock(pinCode);
        assertFalse(smartDoorLock.isLocked());

    }
    @Test
    public void testUnlockWithWrongPin(){
        smartDoorLock.setPin(pinCode);
        smartDoorLock.lock();
        smartDoorLock.unlock(WrongCode);
        assertTrue(smartDoorLock.isLocked());
        assertEquals(1,smartDoorLock.getFailedAttempts());
    }
    @Test
    public void testUnlockWithWrongPinMultipleTimes(){
        smartDoorLock.setPin(pinCode);
        smartDoorLock.lock();
        for(int i=0; i<= smartDoorLock.getMaxAttempts();i++){
            smartDoorLock.unlock(WrongCode);
        }
        assertTrue(smartDoorLock.isBlocked());
    }
    @Test
    public void testCannotUnlockWhenBlocked() {
        smartDoorLock.setPin(pinCode);
        smartDoorLock.lock();
        for (int i = 0; i <= smartDoorLock.getMaxAttempts(); i++) {
            smartDoorLock.unlock(WrongCode);
        }
        smartDoorLock.unlock(pinCode);
        assertTrue(smartDoorLock.isBlocked());
    }
    @Test
    public void testReset(){
        smartDoorLock.setPin(pinCode);
        smartDoorLock.lock();
        for(int i=0; i<= smartDoorLock.getMaxAttempts();i++){
            smartDoorLock.unlock(WrongCode);
        }
        assertTrue(smartDoorLock.isBlocked());
        smartDoorLock.reset();
        assertFalse(smartDoorLock.isBlocked());
    }

}
