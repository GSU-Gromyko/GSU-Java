import practice3_1.Discount;
import practice3_1.DiscountPlus;
import practice3_1.Purchase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Runner_3_1 {
    public static void main(String[] args) throws IOException {

        // 1
        Purchase[] purchases = new Purchase[6];

        //2-5
        FileReader file = new FileReader("/home/vitya/IT/java/src/in.txt");
        Scanner scan = new Scanner(file);

        double maxCost = 0;
        Purchase maxPurchase = new Purchase();

        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            String[] item = scan.nextLine().split(" ");
            String type = item[0];
            String name = item[1];
            double price = Double.parseDouble(item[2]);
            int count = Integer.parseInt(item[3]);

            switch (type) {
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

            //3
            System.out.println(purchases[i].toString());

            //4
            if (purchases[i].getCost() > maxCost) {
                maxCost = purchases[i].getCost();
                maxPurchase = purchases[i];
            }

            //5
            for (int j = 0; j < i; j++){
                if (purchases[i].equals(purchases[j])){
                    System.out.println("Find duplicates: " + purchases[i].toString());
                }
            }


        }
        file.close();

        //4
        System.out.println("Max cost: " + maxPurchase.toString());

    }
}
