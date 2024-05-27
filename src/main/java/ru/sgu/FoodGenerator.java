import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodGenerator implements Generateable<Food> {

    private Random intGenerator = new Random();

    List<String> foodOption = Arrays.asList(
            "Борщ",
            "Окрошка",
            "Яичница",
            "Суп",
            "Котлета",
            "Шашлык",
            "Чипсы",
            "Онигири",
            "Фобо",
            "Том ям"
    );

    @Override
    public Food generate() {
        int index = intGenerator.nextInt(foodOption.size());
        int calories = intGenerator.nextInt(1, 1000);

        return new Food(calories, foodOption.get(index));
    }
}
