import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {

        class Runner{

            // a - x
            // h - step
            // n - count
            float a, h;
            int n;

            Runner(float x, float step, int count){
                a = x;
                h = step;
                n = count;
            }

            float func(float x){
                return (float) (x + Math.cos(Math.toDegrees(Math.pow(x, 2))));
            }

            void get_results(){
                for (int i = 0; i < n; i++) {
                    System.out.println(func(a + h * i));
                }
            }
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Введите Х, шаг и количество итераций");
        Runner run = new Runner(in.nextFloat(), in.nextFloat(), in.nextInt());
        run.get_results();

    }
}
