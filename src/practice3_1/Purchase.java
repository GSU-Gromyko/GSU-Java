package practice3_1;

public class Purchase {

    private String name;
    private double price;
    private int count;

    public Purchase() {
        this.name = "Commodity";
        this.price = 0;
        this.count = 0;
    }

    public Purchase(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost(){
        return price * count;
    }

    public String toString(){
        return name + ";" + price + ";" + count;
    }

    public boolean equals(Purchase purchase){
        return this.name.equals(purchase.name) & this.price == purchase.price;
    }
}
