import java.util.Objects;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


interface Sellable {
    double getPrice();
    String getDescription();
}

abstract class Product implements Sellable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Товар: " + name + ", Цена: " + price + "р.";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Товар{название='" + name + "', цена=" + price + "}";
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}

class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Автор: " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Book book = (Book) obj;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return "Книга{" + super.toString() + ", Автор='" + author + "'}";
    }

    @Override
    public Book clone() {
        return (Book) super.clone();
    }
}

class Electronic extends Product {
    private int warrantyPeriod; // in months

    public Electronic(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Гарантия действует: " + warrantyPeriod + " месяцев";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Electronic that = (Electronic) obj;
        return warrantyPeriod == that.warrantyPeriod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyPeriod);
    }

    @Override
    public String toString() {
        return "Электроника{" + super.toString() + ", Гарантийиный период=" + warrantyPeriod + "}";
    }

    @Override
    public Electronic clone() {
        return (Electronic) super.clone();
    }
}

class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(String name, double price, String size, String color) {
        super(name, price);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Размер: " + size + ", Цвет: " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Clothing clothing = (Clothing) obj;
        return size.equals(clothing.size) && color.equals(clothing.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, color);
    }

    @Override
    public String toString() {
        return "Одежда{" + super.toString() + ", Размер='" + size + "', Цвет='" + color + "'}";
    }

    @Override
    public Clothing clone() {
        return (Clothing) super.clone();
    }
}

class Groceries extends Product {
    private LocalDate expirationDate;

    public Groceries(String name, double price, LocalDate expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Годен до: " + expirationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Groceries food = (Groceries) obj;
        return expirationDate.equals(food.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expirationDate);
    }

    @Override
    public String toString() {
        return "Продукт{" + super.toString() + ", Годен до=" + expirationDate + "}";
    }

    @Override
    public Groceries clone() {
        return (Groceries) super.clone();
    }
}


public class Task1 {
    public static void main(String[] args) {
        List<Sellable> products = new ArrayList<>();

        products.add(new Book("Бледный огонь", 550, "Владимир Набоков"));
        products.add(new Electronic("Электрогриль", 14.999, 12));
        products.add(new Clothing("Футболка", 785, "M", "Белый"));
        products.add(new Groceries("Бананы", 73, LocalDate.of(2024, 6, 1)));

        for (Sellable product : products) {
            System.out.println(product.getDescription());
        }
    }
}
