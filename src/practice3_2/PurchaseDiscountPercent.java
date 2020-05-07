package practice3_2;

public class PurchaseDiscountPercent extends AbstractPurchase implements ShowInfo {

    private double discount ;

    public PurchaseDiscountPercent(Commodity commodity, int numberOfPurchasedUnits, double discount) {
        super(commodity, numberOfPurchasedUnits);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        return getCommodity().getPrice() * getNumberOfPurchasedUnits() * (100-discount)/100;
    }
}
