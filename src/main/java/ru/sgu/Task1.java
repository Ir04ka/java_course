import java.io.*;
import java.util.*;

class Stock implements Comparable<Stock> {
    String fullName;
    String companyName;
    String firstName;
    String secondName;
    String lastName;
    int rating;

    public Stock(String fullName, String companyName, int rating) {
        this.fullName = fullName;

        String[] split = fullName.split(" ");
        this.firstName = split[1];
        this.secondName = split[2];
        this.lastName = split[0];

        this.companyName = companyName;
        this.rating = rating;
    }

    public int compareTo(Stock other) {

        if (this.rating != other.rating) {
            return other.rating - this.rating;
        }

        int cmp = this.lastName.compareTo(other.lastName);
        if (cmp != 0) {
            return cmp;
        }

        cmp = other.firstName.compareTo(this.firstName);
        if (cmp != 0) {
            return cmp;
        }

        return this.secondName.compareTo(other.secondName);
    }
}

public class Task1 {

    public final static String PATH_TO_INPUT_FILE = "data/input.txt";
    public final static String PATH_TO_OUTPUT_FILE = "data/output.txt";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_INPUT_FILE));
            PrintWriter writer = new PrintWriter(new FileWriter(PATH_TO_OUTPUT_FILE));

            TreeSet<Stock> stocks = new TreeSet<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String fullName = parts[0] + " " + parts[1] + " " + parts[2];
                String companyName = parts[3];
                int rating = Integer.parseInt(parts[4]);

                stocks.add(new Stock(fullName, companyName, rating));
            }

            for (Stock stock : stocks) {
                writer.println(stock.fullName + " " + stock.companyName + " " + stock.rating);
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
