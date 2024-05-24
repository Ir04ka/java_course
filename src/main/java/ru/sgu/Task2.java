import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Task2 {

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 7, 3, 10, 6, 1, 4, 9};

        Optional<Integer> secondLargest = Arrays.stream(numbers)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        Optional<Integer> thirdSmallest = Arrays.stream(numbers)
                .boxed()
                .distinct()
                .sorted()
                .skip(2)
                .findFirst();

        secondLargest.ifPresentOrElse(
                num -> System.out.println("Второе наибольшее число: " + num),
                () -> System.out.println("Второе наибольшее число не найдено"));

        thirdSmallest.ifPresentOrElse(
                num -> System.out.println("Третье наименьшее число: " + num),
                () -> System.out.println("Третье наименьшее число не найдено"));
    }
}
