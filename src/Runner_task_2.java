import by.gsu.pms.Discount;
import by.gsu.pms.DiscountPlus;
import by.gsu.pms.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Runner_task_2 {
    public static void main(String[] args) throws IOException {

        // 1
        Purchase[] purchases = new Purchase[6];

        //2
        FileReader file = new FileReader("/home/vitya/IT/java/src/in.txt");
        Scanner scan = new Scanner(file);

        int i = 0;
        while (scan.hasNextLine()){
            String[] item = scan.nextLine().split(" ");
            String type = item[0];
            String name = item[1];
            double price = Double.parseDouble(item[2]);
            int count = Integer.parseInt(item[3]);

            switch (type){
                case ("Purchase"):
                    purchases[i] = new Purchase(name, price, count);
                    break;
                case ("Discount"):
                    purchases[i] = new Discount(name, price, count);
                    break;
                case ("DiscountPlus"):
                    purchases[i] = new DiscountPlus(name, price, count);
                    break;
            }
            i++;
        }
        file.close();

        //3
        for (Purchase purchase: purchases){
            System.out.println(purchase.toString());
        }

        //4
        System.out.println("Purchases:");
        double maxCost = 0;
        Purchase maxPurchase = new Purchase();
        for (Purchase purchase: purchases){
            if (purchase.getCost() > maxCost){
                maxCost = purchase.getCost();
                maxPurchase = purchase;
            }
        }
        System.out.println("Max cost: " + maxPurchase.toString());

        //5

        

    }
}
