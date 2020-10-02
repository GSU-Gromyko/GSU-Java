package gsu;

public class ThreadGenerator {
    private CalculatorThread[] threads;
    private final OperationType operationType;

    ThreadGenerator(int countOfThreads, OperationType operationType, int maxValue) {
        this.operationType = operationType;

        System.out.println("Count of threads: " + countOfThreads +
                "\nMax value: " + maxValue +
                "\nOperation type:" + operationType);

        if (maxValue > countOfThreads && maxValue % countOfThreads == 0) {
            CalculatorThread[] arrayThreads = new CalculatorThread[countOfThreads];

            int threadCapacity = maxValue / countOfThreads;
            for (int i = 0; i < countOfThreads; i++) {

                int start = i * threadCapacity + 1;
                int end = i * threadCapacity + threadCapacity;

                arrayThreads[i] = new CalculatorThread(start, end);
            }
            this.threads = arrayThreads;
        } else {
            System.out.println("Error maxValue must be greater than countOfThreads!");
        }
    }

    public void execute() {
        for (CalculatorThread thread: this.threads){
            thread.start();
        }
    }

    public int getResult() throws InterruptedException {
        int result = operationType.ordinal() < 2 ? 0 : 1;
        for (CalculatorThread thread: this.threads){
            thread.join();
            switch (this.operationType.ordinal()){
                case (0):
                    result += thread.getResult();
                    break;
                case (1):
                    result -= thread.getResult();
                    break;
                case (2):
                    result *= thread.getResult();
                    break;
                default:
                    System.out.println("Operation type Error!");
                    break;
            }
        }
        return result;
    }
}

