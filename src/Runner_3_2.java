import practice3_2.*;

import java.util.Arrays;
import java.util.Comparator;

public class Runner_3_2 {
    public static void main(String[] args) {

        // 1
        Commodity milk = new Commodity("milk", 2);
        Commodity iceCream = new Commodity("ice cream", 1.2);

        // 2
        AbstractPurchase[] purchases = new AbstractPurchase[6];
        purchases[0] = new PurchaseDiscountPrice(milk, 2, 0.2);
        purchases[1] = new PurchaseDiscountPrice(iceCream, 5, 0.3);
        purchases[2] = new PurchaseDiscountPercent(milk, 3, 20);
        purchases[3] = new PurchaseDiscountPercent(iceCream, 7, 15);
        purchases[4] = new PurchaseTransport(milk, 6, 5);
        purchases[5] = new PurchaseTransport(iceCream, 9, 6);

        // 3
        for (AbstractPurchase purchase: purchases){
            System.out.println(purchase.toString());;
        }

        // 4
        Arrays.sort(purchases, Comparator.comparing(AbstractPurchase::getCost));

        // 5
        System.out.println("Sorted:");
        for (AbstractPurchase purchase: purchases){
            System.out.println(purchase.toString());
        }

        // 6
        System.out.println("Min cost:");
        System.out.println(purchases[0].toString());

    }
}
