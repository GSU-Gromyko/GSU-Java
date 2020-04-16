package by.gsu.pms;

public class PricePurchase extends Purchase {

    private int discount;

    public PricePurchase(String name, int cost, int count, int discount) {
        super(name, cost, count);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void show(){
        System.out.println("Name: "+getName()+" Cost: "+getCost()+" Count: "+getCount()+" Discount: "+discount
                +" Price: "+get_price());
    }

    public int get_price(){
        return (getCost() - discount) * getCount();
    }

}
