import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
