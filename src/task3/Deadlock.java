package task3;

public class Deadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void deadlock() {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("T1 lock1 oldi");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock2) {
                    System.out.println("T1 lock2 oldi");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("T2 lock2 oldi");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock1) {
                    System.out.println("T2 lock1 oldi");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public void fix() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("T1 ishladi");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("T2 ishladi");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}