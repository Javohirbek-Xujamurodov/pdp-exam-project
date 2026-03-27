package task1;

import java.util.concurrent.locks.ReentrantLock;

public class RaceCondition {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void unsafeIncriment() {
        counter++;
    }

    public void safeIncrement() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}