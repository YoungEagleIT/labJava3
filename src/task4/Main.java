package task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(final String[] args) {
        final Thread thread1 = new MathOperationThread();
        final Thread thread2 = new MathOperationThread(32.3);

        thread1.start();
        thread2.start();

        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new MathOperation(-0.6));
        executorService.execute(new MathOperation());

        executorService.shutdown();
    }
}
