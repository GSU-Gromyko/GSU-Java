import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {

        class Runner{

            // a - x, h - step, n - count
            // m - ограничение для 2й части задания
            float a, h, m;
            int n;

            public Runner(float x, float step, int count){
                a = x;
                h = step;
                n = count;
            }

            public Runner(float x, float step, int count, float limit) {
                a = x;
                h = step;
                n = count;
                m = limit;
            }

            float func(float x){
                return (float) (x + Math.cos(Math.toDegrees(Math.pow(x, 2))));
            }

            void get_results(){
                for (int i = 0; i < n; i++) {
                    float value = a + h * i;
                    if (m != 0 && value > m){
                        System.out.println("Х вышел за область установленных значений");
                    } else {
                        System.out.println(func(value));
                    }
                }
            }
        }


        Scanner in = new Scanner(System.in);


        System.out.println("Введите Х, шаг и количество итераций");
        Runner part_1 = new Runner(in.nextFloat(), in.nextFloat(), in.nextInt());
        part_1.get_results();

        System.out.println("Введите Х, шаг, количество итераций и ограничитель");
        Runner part_2 = new Runner(in.nextFloat(), in.nextFloat(), in.nextInt(), in.nextFloat());
        part_2.get_results();

    }
}
