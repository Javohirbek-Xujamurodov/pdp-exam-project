package task1;

import task1.RaceCondition;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RaceCondition rc = new RaceCondition();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                rc.unsafeIncriment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                rc.unsafeIncriment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Race condition natijasi: " + rc.getCounter());

        RaceCondition fixed = new RaceCondition();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                fixed.safeIncrement();
            }
        });


        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                fixed.safeIncrement();
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("ReentrantLock bilan natija: " + fixed.getCounter());
    }
}