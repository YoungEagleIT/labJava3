package task4;

public class MathOperationThread extends Thread {
    protected Double mainNumber = 0.;

    public MathOperationThread(final Double mainNumber) {
        this.mainNumber = mainNumber;
    }

    public MathOperationThread() {

    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                mainNumber += i * 0.1;

                try {
                    Thread.sleep(100);
                } catch (final InterruptedException ex) {
                    System.out.println("InterruptedException ex");
                }
            }
            System.out.println("first loop in " + Thread.currentThread().getName());
            for (int i = 1; i < 10; i++) {
                mainNumber *= i;
                try {
                    Thread.sleep(100);
                } catch (final InterruptedException ex) {
                    System.out.println("InterruptedException ex");
                }
            }
            System.out.println("second loop in " + Thread.currentThread().getName());
            System.out.println("mainNumber = " + mainNumber);
        }
    }
}
