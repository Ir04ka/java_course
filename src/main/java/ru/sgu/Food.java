public class Food implements Summable, Printable {
    private final int calories;
    private final String name;

    public Food(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    @Override
    public int get() {
        return calories;
    }

    @Override
    public String print() {
        return "блюдо \"" + name + "\" с количеством калорий " + calories;
    }
}
