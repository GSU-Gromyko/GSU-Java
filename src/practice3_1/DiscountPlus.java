package practice3_1;

public class DiscountPlus extends Purchase {

    private static int COUNT = 5;
    private int discount = 20;

    public DiscountPlus(String name, double price, int count) {
        super(name, price, count);
    }

    @Override
    public double getCost() {
        if (getCount() > COUNT){
            return getPrice() * getCount() * (100- discount) / 100;
        } else {
            return super.getCount();
        }
    }
}
