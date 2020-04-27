package practice3_1;

public class DiscountPrice extends Purchase {

    private int discount; // percents

    public DiscountPrice(String name, double price, int count, int discount) {
        super(name, price, count);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        return super.getCost() * (100- discount) / 100;
    }

    @Override
    public String toString(){
        return super.toString() + ";" + discount;
    }
}
