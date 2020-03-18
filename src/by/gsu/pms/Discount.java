package by.gsu.pms;

public class Discount extends Purchase {

    private int discount = 20; // percents

    public Discount(String name, double price, int count) {
        super(name, price, count);
    }

    @Override
    public double getCost() {
        return getPrice() * getCount() * (100- discount) / 100;
    }
}
