package by.gsu.ms32lab;

public class Detail {

    private String name;
    private Material material;
    private double volume;

    public Detail() {
        this.name = "Detail";
        this.material = new Material();
        this.volume = 1000;

    }

    public Detail(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass(){
        return material.getDensity() * volume;
    }

    public String toString() {

        return name + ";" + material.toString() + ";" + volume + ";" + getMass();
    }

}
