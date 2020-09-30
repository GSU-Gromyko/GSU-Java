package gsu;

public class Runner{
    public static void main(String[] args) throws InterruptedException {

        ThreadGenerator calculator_1 = new ThreadGenerator(3, OperationType.ADDITION, 12);
        calculator_1.execute();
        System.out.println("RESULT: " + calculator_1.getResult() + "\n");

        ThreadGenerator calculator_2 = new ThreadGenerator(2, OperationType.SUBTRACTION, 12);
        calculator_2.execute();
        System.out.println("RESULT: " + calculator_2.getResult() + "\n");

        ThreadGenerator calculator_3 = new ThreadGenerator(6, OperationType.MULTIPLICATION, 12);
        calculator_3.execute();
        System.out.println("RESULT: " + calculator_3.getResult() + "\n");

    }
}