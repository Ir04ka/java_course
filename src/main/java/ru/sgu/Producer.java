import java.util.concurrent.SynchronousQueue;


public class Producer<T> implements Runnable  {
    private SynchronousQueue<T> queue;
    private Generateable<T> generator;
    private final int n;
    private final int timeToSleep;

    public Producer(SynchronousQueue<T> queue, Generateable<T> generator, int n, int timeToSleep) {
        this.queue = queue;
        this.generator = generator;
        this.n = n;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            T element = generator.generate();

            try {
                queue.put(element);
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
