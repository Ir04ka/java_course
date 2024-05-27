import java.util.concurrent.atomic.AtomicInteger;

public class Task1 implements Runnable {

    final static int INCREMENT_NUMBER = 100_000_000;

    public IntegerWrapper number;

    public Task1(IntegerWrapper number) {
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < INCREMENT_NUMBER; i++) {
            number.inc();
        }
    }
    public static void main(String[] args) {
        IntegerWrapper number = new IntegerWrapper();

        Runnable r1 = new Task1(number);
        Runnable r2 = new Task1(number);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(number.getInteger());
    }
}

class IntegerWrapper {
    public AtomicInteger integer = new AtomicInteger(0);

    public void inc() {
        integer.incrementAndGet();
    }

    public int getInteger() {
        return integer.get();
    }
}

/*
Incorrect realization
class IntegerWrapper {
    public int integer = 0;

    public void inc() {
        integer++;
    }

    public int getInteger() {
        return integer;
    }
}
*/
