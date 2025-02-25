package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {
    private Integer pin;
    private boolean locked;
    private boolean blocked;
    private int failedAttempts=0;
    private int MAX_ATTEMPTS = 5;

    public SmartDoorLockImpl() {
        this.pin = null;
        this.locked = false;
        this.blocked = false;
    }
    public void setPin(int pin) {
        if(!this.locked && !this.blocked && this.pin == null)
            this.pin = pin;
        else
            throw new IllegalStateException("Cannot set pin when locked!");
    }

    @Override
    public void unlock(int pin) {
        if(this.pin != null && pin == this.pin){
            this.locked= false;
            failedAttempts = 0;
        } else if(blocked){
            return;
        }
        else if(failedAttempts == MAX_ATTEMPTS) {
            this.blocked = true;
        }
        else{
            failedAttempts++;
        }
    }

    @Override
    public void lock() {
        if (pin == null) {
            throw new IllegalStateException("Cannot lock without setting a PIN");
        }
        this.locked = true;
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
