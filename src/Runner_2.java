import practice2.Detail;
import practice2.Material;

public class Runner_2 {
    public static void main(String[] args) {

        Material steel = new Material("Steel", 7800);
        Material copper = new Material("copper", 8500);

        // 1
        Detail wire = new Detail("Wire", steel, 0.03);

        // 2
        System.out.println(wire.toString());

        //3
        wire.setMaterial(copper);
        System.out.println(wire.getMass());

        //4
        wire.setMaterial(steel);
        System.out.println(wire.toString());

    }
}
