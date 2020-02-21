package purchases;

public class Purchase {

    private int cost;
    private String name;
    public Days day;
    private int count;

    public Purchase(int cost, String name, Days day, int count) {
        this.cost = cost;
        this.name = name;
        this.day = day;
        this.count = count;
    }

    public int money(){
        return cost * count;
    }
}
