package practice3_1;

public class FactoryDiscount {

    public Purchase Factory(String type, String name, double price, int count) {
        switch (type) {
            case ("Purchase"):
                return new Purchase(name, price, count);
            case ("Discount"):
                return new DiscountPrice(name, price, count);
            case ("DiscountPlus"):
                return new DiscountRequirement(name, price, count);
        }
        return null;
    }
}
