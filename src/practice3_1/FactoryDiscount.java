package practice3_1;

public class FactoryDiscount {

    public Purchase Factory(String string){
        String[] params = string.split(" ");
        switch (params[0]){
            case ("Purchase"):
                return new Purchase(params[1], Double.parseDouble(params[2]), Integer.parseInt(params[3]));
            case ("Discount"):
                return new DiscountPrice(params[1], Double.parseDouble(params[2]), Integer.parseInt(params[3]),
                        Integer.parseInt(params[4]));
            case ("DiscountPlus"):
                return new DiscountRequirement(params[1], Double.parseDouble(params[2]), Integer.parseInt(params[3]),
                        Integer.parseInt(params[4]), Integer.parseInt(params[5]));
        }
        return null;
    }
}
