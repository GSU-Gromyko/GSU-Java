package practice3_2;

public class PurchaseTransport extends AbstractPurchase implements ShowInfo {

    private double transportExpenses;

    public PurchaseTransport(Commodity commodity, int numberOfPurchasedUnits, double transportExpenses) {
        super(commodity, numberOfPurchasedUnits);
        this.transportExpenses = transportExpenses;
    }

    public double getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(double transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    @Override
    public double getCost() {
        return getCommodity().getPrice() * getNumberOfPurchasedUnits() + transportExpenses;
    }
}
