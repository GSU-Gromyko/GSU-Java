package practice2;

public class Material {
    private String name;
    private int density;

    public Material() {
        this.name = "Material";
        this.density = 1000;
    }

    public Material(String name, int density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public String toString() {

        return name + ";" + density;
    }


}
