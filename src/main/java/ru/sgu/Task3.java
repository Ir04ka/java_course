package main.java.ru.sgu;

import java.io.*;

import static java.lang.Character.toUpperCase;

public class Task3 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
            FileWriter writer = new FileWriter("src/output.txt");

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    writer.write("\n");
                    continue;
                }

                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String middleName = parts[0];
                    String firstName = parts[1];
                    String lastName = parts[2];

                    if (isWord(middleName) && isWord(firstName) && isWord(lastName)) {
                        writer.write(capitilize(firstName) + " " + toUpperCase(middleName.charAt(0)) + "." + toUpperCase(lastName.charAt(0)) + ".\n");
                    } else {
                        writer.write("...есть разные варианты...\n");
                    }
                } else {
                    writer.write("...есть разные варианты...\n");
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Произошло исключение во время работы с файлами");
            e.printStackTrace();
        }
    }

    private static String capitilize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private static boolean isWord(String str) {
        return str.matches("[а-яА-Яa-zA-Z]+");
    }
}
