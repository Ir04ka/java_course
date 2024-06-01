import java.time.LocalDate;
import java.util.Objects;

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
        Clothing clonedClothing = (Clothing) super.clone();
        return clonedClothing;
    }

    @Override
    public Clothing deepClone() {
        Clothing clonedGroceries = new Clothing(new String(this.getName()), this.getPrice(), new String(size), new String(color));
        return clonedGroceries;
    }
}

