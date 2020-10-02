package gsu;

public class CalculatorThread extends Thread {

    private long result;
    private final int minValue;
    private final int maxValue;

    public long getResult() {
        return this.result;
    }

    public CalculatorThread(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " starting...");
        for (int i = this.minValue; i <= this.maxValue; i++) {
            if (i % 3 == 0) {
                this.result += i;
            }
        }
        System.out.println("Result of " + threadName + " is " + this.result);
    }
}
