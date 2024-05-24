import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> filterStream(Stream<Integer> stream, Predicate<Integer> condition) {
        return stream.filter(condition).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Stream<Integer> numberStream = Stream.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        Predicate<Integer> condition = Task1::isPrime;

        List<Integer> filteredNumbers = filterStream(numberStream, condition);

        filteredNumbers.forEach(System.out::println);
    }
}
