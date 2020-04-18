package practice3_1;

public class DiscountPrice extends Purchase {

    private int discount = 20; // percents

    public DiscountPrice(String name, double price, int count) {
        super(name, price, count);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        return getPrice() * getCount() * (100- discount) / 100;
    }
}
