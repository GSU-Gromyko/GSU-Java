package practice3_2;

public class Commodity {
    private String name;
    private double price;

    public Commodity() {
        this.name = "Not set";
        this.price = 0;
    }

    public Commodity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return name + ";" + price;
    }
}
