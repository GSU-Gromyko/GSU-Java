package practice3_2;

public abstract class AbstractPurchase {

    private Commodity commodity;
    private int numberOfPurchasedUnits;

    public AbstractPurchase() {
        this.commodity = new Commodity();
        this.numberOfPurchasedUnits = 0;
    }

    public AbstractPurchase(Commodity commodity, int numberOfPurchasedUnits) {
        this.commodity = commodity;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public abstract double getCost();

    public String toString(){
        return commodity.toString() + ";" + numberOfPurchasedUnits + ";" + getCost();
    }

    public boolean CompareTo(AbstractPurchase purchase){
        return getCost() > purchase.getCost();
    }
}
