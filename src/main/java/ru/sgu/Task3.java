import java.util.concurrent.SynchronousQueue;

public class Task3 {

    static int CONSUMERS_NUMBER = 10;
    static int PRODUCERS_NUMBER = 10;
    static int NUMBER_FOOD_TO_GENERATE = 10;
    static int TIME_TO_SLEEP_FOR_PRODUCER = 1000;

    public static void main(String[] args) {
        SynchronousQueue<Food> queue = new SynchronousQueue<>();

        for (int i = 0; i < CONSUMERS_NUMBER; i++) {
            Thread thread = new Thread(new Consumer<Food>(
                    queue,
                    "Потребитель " + i
            ));
            thread.start();
        }

        for (int i = 0; i < PRODUCERS_NUMBER; i++) {
            Generateable<Food> generator = new FoodGenerator();

            Thread producerThread = new Thread(new Producer<>(
                    queue,
                    generator,
                    NUMBER_FOOD_TO_GENERATE,
                    TIME_TO_SLEEP_FOR_PRODUCER
            ));
            producerThread.start();
        }
    }

}
