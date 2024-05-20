package main.java.ru.sgu;

import java.util.Random;

public class Task3 {

    public static void main(String[] args) {
        long startTimeStringBuilder = System.nanoTime();
        stringBuilderConcatenation();
        long endTimeStringBuilder = System.nanoTime();
        long durationStringBuilder = endTimeStringBuilder - startTimeStringBuilder;
        System.out.println("Время с использованием StringBuilder: " + durationStringBuilder + " наносекунд");

        long startTimeStringBuffer = System.nanoTime();
        stringBufferConcatenation();
        long endTimeStringBuffer = System.nanoTime();
        long durationStringBuffer = endTimeStringBuffer - startTimeStringBuffer;
        System.out.println("Время с использованием StringBuffer: " + durationStringBuffer + " наносекунд");

        long startTimeStringConcatenation = System.nanoTime();
        stringConcatenation();
        long endTimeStringConcatenation = System.nanoTime();
        long durationStringConcatenation = endTimeStringConcatenation - startTimeStringConcatenation;
        System.out.println("Время с использованием String Concatenation: " + durationStringConcatenation + " наносекунд");
    }

    public static void stringBuilderConcatenation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(generateRandomString());
        }
    }

    public static void stringBufferConcatenation() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(generateRandomString());
        }
    }

    public static void stringConcatenation() {
        String concatenatedString = "";
        for (int i = 0; i < 100000; i++) {
            concatenatedString += generateRandomString();
        }
    }

    public static String generateRandomString() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(10);
            randomString.append(symbols.charAt(index));
        }
        return randomString.toString();
    }

    private static Random random = new Random();
}
