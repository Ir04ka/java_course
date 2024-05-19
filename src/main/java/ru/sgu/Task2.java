package main.java.ru.sgu;

import java.util.Scanner;

public class Task2 {
    public enum DayOfWeek {
        MONDAY(0),
        TUESDAY(1),
        WEDNESDAY(2),
        THURSDAY(3),
        FRIDAY(4),
        SATURDAY(5),
        SUNDAY(6);

        DayOfWeek(int number) {
            this.number = number;
        }

        final int number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите день недели и количество дней:");
        String inputDay = scanner.next();
        int daysToAdd = scanner.nextInt();

        try {
            DayOfWeek curr = DayOfWeek.valueOf(inputDay.toUpperCase());

            int nextDay = (curr.number + daysToAdd) % 7;

            DayOfWeek[] weekArr = {
                    DayOfWeek.MONDAY,
                    DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY,
                    DayOfWeek.FRIDAY,
                    DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
            };

            System.out.println("Это будет: " + "\n" + weekArr[nextDay].toString().toLowerCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка. Такого дня не существует.");
        }
    }
}
