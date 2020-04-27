import by.gsu.pms.PricePurchase;
import by.gsu.pms.Purchase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Runner {
    public static void main(String[] args) throws IOException {

        ArrayList<Purchase> purchases = new ArrayList<>();

        // 1. Load the content of input file into collection.
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/data.csv"));

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {

            String[] params = currentLine.split(";");

            switch (params.length){
                case 3:
                    purchases.add(new Purchase(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
                    break;
                case 4:
                    purchases.add(new PricePurchase(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]),
                            Integer.parseInt(params[3])));
                    break;
            }
        }
        bufferedReader.close();

        // 2. Print collection by separate for–each cycle.
        System.out.println("Print:");
        for (Purchase purchase: purchases){
            System.out.println(purchase.toString());
        }

        // 3. Print the purchase with the index 6.
        System.out.println("Element with index 6:");
        System.out.println(purchases.get(6).toString());

        // 4. Delete purchases with the price less than 10000 (use iterator).
        Iterator<Purchase> iterator = purchases.iterator();
        while (iterator.hasNext()){
            Purchase purchase = iterator.next();
            if (purchase.get_price() < 10000){
                iterator.remove();
            }
        }

        /* 5. Sort collection by the cost increasing (use the method Collections.sort(), the superclass Purchase should
        implement the interface Comparable). */
        Collections.sort(purchases);


        // 6. Print collection by separate for–each cycle.
        System.out.println("Print:");
        for (Purchase purchase: purchases){
            System.out.println(purchase.toString());
        }

        // 7. Find and print any purchase with the cost equaled 35000 (use the method Collections.binarySearch().
        Comparator<Purchase> c = new Comparator<Purchase>() {
            public int compare(Purchase p1, Purchase p2) {
                return Integer.compare(p1.getCost(), p2.getCost());
            }
        };

        int index = Collections.binarySearch(purchases, new Purchase("", 8500, 0), c);
        System.out.println("Index: "+index);
    }
}
