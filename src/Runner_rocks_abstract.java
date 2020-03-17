import rocks_abstract.PreciousStone;
import rocks_abstract.SemipreciousStone;
import rocks_abstract.Stone;
import rocks_abstract.WriterInfo;

import java.util.Arrays;
import java.util.Comparator;

public class Runner_rocks_abstract {
    public static void main(String[] args) {

        Stone[] stones = new Stone[6];

        stones[0] = new PreciousStone(5, 0.4, 15, 0.31, 0.27);
        stones[1] = new PreciousStone(6, 0.37, 17, 0.4, 0.21);
        stones[2] = new PreciousStone(3, 0.43, 16, 0.46, 0.24);
        stones[3] = new SemipreciousStone(7, 0.6, 38, 0.6, 0.62);
        stones[4] = new SemipreciousStone(6, 0.72, 44, 0.8, 0.74);
        stones[5] = new SemipreciousStone(5, 0.65, 37, 0.77, 0.68);

        System.out.println("List of stones:");
        for (Stone stone: stones){
            WriterInfo.Info(stone);
        }

        double stonesWeight = 0;
        double stonesPrice = 0;
        for (Stone stone: stones){
            stonesWeight += stone.getWeight();
            stonesPrice += stone.getPrice();
        }
        System.out.println("Weight: "+stonesWeight+" Price: "+stonesPrice);

        // SORTING
        System.out.println("Sorting by price:");
        Stone[] sorted_stones = stones.clone();
        Arrays.sort(sorted_stones, Comparator.comparing(Stone::getPrice));
        for (Stone stone: sorted_stones){
            WriterInfo.Info(stone);
        }

        // FIND
        double desiredDensity = 0.6;
        System.out.println("Desired density = "+desiredDensity+" Rocks:");
        for (Stone stone: stones){
            if (stone.getTransparency() >= desiredDensity){
                WriterInfo.Info(stone);
            }
        }


    }
}
