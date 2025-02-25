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


}
