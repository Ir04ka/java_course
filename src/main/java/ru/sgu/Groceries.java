import java.time.LocalDate;
import java.util.Objects;

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
        Groceries clonedGroceries = (Groceries) super.clone();
        return clonedGroceries;
    }

    @Override
    public Groceries deepClone() {
        LocalDate nExpirationDate = LocalDate.of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
        Groceries clonedGroceries = new Groceries(new String(this.getName()), this.getPrice(), nExpirationDate);
        return clonedGroceries;
    }
}
