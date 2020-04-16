package by.gsu.pms;

public class Purchase implements Comparable<Purchase>{
    public void setCount(int count) {
        this.count = count;
    }

    private String name;
    private int cost;

    private int count;

    public Purchase(String name, int cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void show(){
        System.out.println("Name: "+name+" Cost: "+cost+" Count: "+count+" Price: "+get_price());
    }

    public int get_price(){
        return cost * count;
    }

    @Override
    public int compareTo(Purchase o){
        return Integer.compare(this.getCost(), o.getCost());
    }
}
