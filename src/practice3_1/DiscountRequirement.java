package practice3_1;

public class DiscountRequirement extends Purchase {

    private static int COUNT = 5;
    private int discount = 20;

    public DiscountRequirement(String name, double price, int count) {
        super(name, price, count);
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public static void setCOUNT(int COUNT) {
        DiscountRequirement.COUNT = COUNT;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        if (getCount() > COUNT){
            return getPrice() * getCount() * (100- discount) / 100;
        } else {
            return super.getCost();
        }
    }
}
