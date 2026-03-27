package task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Deadlock:");

        Deadlock deadlockDemo = new Deadlock();
        deadlockDemo.deadlock();

        Thread.sleep(1000);

        System.out.println("Fix:");

        Deadlock fixDemo = new Deadlock();
        fixDemo.fix();
    }
}