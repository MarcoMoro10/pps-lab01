package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {
    private Integer pin;
    private boolean locked;
    private boolean blocked;

    public SmartDoorLockImpl() {
        this.pin = null;
        this.locked = false;
        this.blocked = false;
    }
    public void setPin(int pin) {
        System.out.println("valori di this.lockd e blocked" + this.locked + " " + this.blocked);
        if(!this.locked && !this.blocked && this.pin == null)
            this.pin = pin;
        else
            throw new IllegalStateException("Cannot set pin when locked!");
    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {

    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public boolean isBlocked() {
        return blocked;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
