package rocks_interfaces;

public class Stone implements BasicStone {
    private double weight;
    private double transparency;
    private double price;

    public Stone(double weight, double transparency, double price) {
        this.weight = weight;
        this.transparency = transparency;
        this.price = price;
    }

    public Stone() {
        this.weight = 1;
        this.transparency = 0.5;
        this.price = 0;
    }

    public Stone(double weight, double price) {
        this.weight = weight;
        this.price = price;
        this.transparency = 0;
    }

    public double getWeight() {
        return weight;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public double getPrice() {
        return price;
    }

    public void showInfo(){
        System.out.println("Weight: "+weight+"Transparency: "+transparency+"Price: "+price);
    }
}

