import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Task2 extends RecursiveTask<BigInteger> {
    private final BigInteger n;
    private final static BigInteger N = BigInteger.valueOf(20);

    public Task2(BigInteger n) {
        this.n = n;
    }

    @Override
    public BigInteger compute() {
        if (n.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ZERO;
        } else if (n.compareTo(BigInteger.TWO) == 0) {
            return BigInteger.ONE;
        } else {
            Task2 f1 = new Task2(n.subtract(BigInteger.valueOf(1)));
            f1.fork();

            Task2 f2 = new Task2(n.subtract(BigInteger.valueOf(2)));

            return f2.compute().add(f1.join());
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Task2 fibonacciCalculator = new Task2(N);
        BigInteger res = forkJoinPool.invoke(fibonacciCalculator);
        System.out.println(res);
    }
}

