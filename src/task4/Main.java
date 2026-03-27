package task4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = "1234";
        int count = 0;
        LocalDateTime blocked = null;

        while (true) {
            LocalDateTime now = LocalDateTime.now();

            if (blocked != null && now.isBefore(blocked)) {
                Duration remaining = Duration.between(now, blocked);
                long minutes = remaining.toMinutes();
                System.out.println("Siz blocksiz. Qolgan vaqt: " + minutes + " daqiqa");
                break;
            }

            System.out.print("Parol kiriting: ");
            String input = scanner.nextLine();

            if (input.equals(password)) {
                System.out.println("Login qildingiz!");
                break;
            } else {
                count++;
                System.out.println("Parol xato. Urinish: " + count + "/3");

                if (count == 3) {
                    blocked = LocalDateTime.now().plusHours(1);
                    System.out.println("3 marta xato kiritildi. Siz 1 soatga block qilindingiz.");
                }
            }
        }

    }
}