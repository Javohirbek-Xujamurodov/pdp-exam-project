package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
    private boolean buffer = false;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition canCook = lock.newCondition();
    private final Condition canServe = lock.newCondition();

    public void cook() throws InterruptedException {
        lock.lock();
        try {
            while (buffer) {
                canCook.await();
            }

            buffer = true;
            System.out.println("Oshpaz ==> taom tayyorladi.");

            canServe.signal();
        } finally {
            lock.unlock();
        }
    }

    public void serve() throws InterruptedException {
        lock.lock();
        try {
            while (!buffer) {
                canServe.await();
            }

            buffer = false;
            System.out.println("Ofitsiant --> taomni olib ketdi.");

            canCook.signal();
        } finally {
            lock.unlock();
        }
    }
}