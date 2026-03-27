package task2;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Thread chef = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    restaurant.cook();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread waiter = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    restaurant.serve();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        chef.start();
        waiter.start();
    }
}