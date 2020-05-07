package practice3_1;

public class DiscountRequirement extends Purchase {

    private int countForDiscount;
    private int discount ;

    public DiscountRequirement(String name, double price, int count, int countForDiscount, int discount) {
        super(name, price, count);
        this.countForDiscount = countForDiscount;
        this.discount = discount;
    }

    public int getCount() {
        return countForDiscount;
    }

    public void setCount(int count) {
        this.countForDiscount = count;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        if (getCount() > countForDiscount){
            return super.getCost() * (100- discount) / 100;
        } else {
            return super.getCost();
        }
    }

    @Override
    public String toString(){
        return super.toString() + ";" + countForDiscount + ";" + discount;
    }
}
