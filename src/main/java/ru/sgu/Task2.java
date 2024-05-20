package main.java.ru.sgu;

import java.math.BigDecimal;
import java.util.Scanner;


public class Task2 {

    enum OperationType {
        ADD, SUB, MULT, DIV, REM, POW
    }

    public static BigDecimal calculate(BigDecimal num1, BigDecimal num2, OperationType operation) {
        BigDecimal result = BigDecimal.ZERO;

        switch (operation) {
            case ADD:
                result = num1.add(num2);
                break;
            case SUB:
                result = num1.subtract(num2);
                break;
            case MULT:
                result = num1.multiply(num2);
                break;
            case DIV:
                if (num2.equals(BigDecimal.ZERO)) {
                    System.out.println("Деление на ноль");
                    return null;
                }
                result = num1.divide(num2);
                break;
            case REM:
                if (num2.equals(BigDecimal.ZERO)) {
                    System.out.println("Деление на ноль");
                    return null;
                }
                result = num1.remainder(num2);
                break;
            case POW:
                int power = num2.intValue();
                result = num1.pow(power);
                break;
            default:
                System.out.println("Недопустимая операция");
                return null;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите через пробел: первое число, второе число и операцию");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("Неверный формат ввода");
            return;
        }

        BigDecimal num1;
        BigDecimal num2;

        try {
            num1 = new BigDecimal(parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка парсинга чисел 1 числа");
            return;
        }

        try {
            num2 = new BigDecimal(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка парсинга чисел 2 числа");
            return;
        }

        OperationType operation;
        try {
            operation = OperationType.valueOf(parts[2]);
        } catch (Exception e) {
            System.out.println("Некорректная операция!");
            return;
        }

        BigDecimal result = calculate(num1, num2, operation);
        if (result != null) {
                System.out.println("Результат: " + result.setScale(15, BigDecimal.ROUND_HALF_UP));
        }
    }
}
