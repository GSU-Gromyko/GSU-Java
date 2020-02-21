import purchases.Days;
import purchases.Purchase;

import java.util.Arrays;

public class Runner_purchases {
     public static void main(String[] args) {

         Purchase garbages[] = new Purchase[6];

         garbages[0] = new Purchase(53, "Cake", Days.FRI, 6);
         garbages[1] = new Purchase(25, "Pizza", Days.FRI, 126);
         garbages[2] = new Purchase(14, "Cookies", Days.THU, 3);
         garbages[3] = new Purchase(62, "Bread", Days.MON, 45);
         garbages[4] = new Purchase(51, "Milk", Days.MON, 12);
         garbages[5] = new Purchase(123, "Subscription", Days.SAT, 9);


         // #
         int days_money[] = new int[7]; // п в с ч п с в
         int monday_money = 0;
         int sum_money = 0;


         for (int garbage_index = 0; garbage_index < garbages.length; garbage_index++) {
             sum_money += garbages[garbage_index].money();
             if (garbages[garbage_index].day == Days.MON){
                 monday_money += garbages[garbage_index].money();
             }

             days_money[Arrays.asList(Days.values()).indexOf(garbages[garbage_index].day)]
                     += garbages[garbage_index].money();
         }

         int max = 0;
         Days day = null;

         for (int i = 0; i < garbages.length; i++) {
             if (days_money[i] > max){
                 max = days_money[i];
                 day = Days.values()[i];
             }
         }

         System.out.println("Max sum in " + day + ". Sum is " + max + ".");
         System.out.println("Monday money:" + monday_money);
         System.out.println("All money:" + sum_money);


         for (int day_i = 0; day_i < days_money.length; day_i++) {
             System.out.println(
                     Days.values()[day_i] + " = " + days_money[day_i]
             );
         }


        }
    }
