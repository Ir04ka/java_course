import java.util.concurrent.SynchronousQueue;

class Consumer<T extends Summable & Printable> implements Runnable {
    private SynchronousQueue<T> queue;
    private int sum = 0;
    private final String name;

    public Consumer(SynchronousQueue<T> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                T element = queue.take();
                sum += element.get();
                System.out.printf("%s потребил %s\n", name, element.print());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
