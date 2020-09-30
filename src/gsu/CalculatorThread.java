package gsu;

public class CalculatorThread extends Thread {

    private int result;
    private int minValue;
    private int maxValue;

    public int getResult() {
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
